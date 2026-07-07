// ================== Member API ==================
const MemberAPI = {
  getAll: (part) => httpFetch('GET', part ? `/members?part=${encodeURIComponent(part)}` : '/members'),
  getById: (id) => httpFetch('GET', `/members/${id}`),
  createLion: (data) => httpFetch('POST', '/members/lions', data),
  createStaff: (data) => httpFetch('POST', '/members/staffs', data),
  updateLion: (id, data) => httpFetch('PUT', `/members/lions/${id}`, data),
  updateStaff: (id, data) => httpFetch('PUT', `/members/staffs/${id}`, data),
  delete: (id) => httpFetch('DELETE', `/members/${id}`),
};

// ================== 멤버 등록 ==================
document.getElementById('member-form').addEventListener('submit', async (e) => {
  e.preventDefault();

  const role = document.getElementById('member-role').value;
  const name = document.getElementById('member-name').value;
  const major = document.getElementById('member-major').value;
  const generation = Number(document.getElementById('member-generation').value);
  const part = document.getElementById('member-part').value;
  const extra = document.getElementById('member-extra').value;

  let result;
  if (role === 'LION') {
    result = await MemberAPI.createLion({ name, major, generation, part, studentId: extra });
  } else {
    result = await MemberAPI.createStaff({ name, major, generation, part, position: extra });
  }

  if (result.ok) {
    showToast('멤버가 등록되었습니다.');
    document.getElementById('member-form').reset();
    loadMembers(document.getElementById('part-filter').value);
    loadMemberOptions();
  }
});

// ================== 멤버 목록 조회 ==================
async function loadMembers(part) {
  const result = await MemberAPI.getAll(part);
  const tbody = document.querySelector('#member-table tbody');
  tbody.innerHTML = '';
  if (!result.ok || !Array.isArray(result.data)) return;

  result.data.forEach((member) => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${member.id}</td>
      <td>${member.name}</td>
      <td>${member.major}</td>
      <td>${member.generation}</td>
      <td>${member.part}</td>
      <td>${member.roleName}</td>
      <td>
        <button class="action-btn edit" onclick="editMember(${member.id})">수정</button>
        <button class="action-btn delete" onclick="deleteMember(${member.id})">삭제</button>
      </td>`;
    tbody.appendChild(tr);
  });
}

document.getElementById('filter-btn').addEventListener('click', () => {
  loadMembers(document.getElementById('part-filter').value);
});

// ================== 멤버 수정 ==================
async function editMember(id) {
  const result = await MemberAPI.getById(id);
  if (!result.ok) return;
  const member = result.data;

  const newName = prompt('이름', member.name);
  if (newName === null) return;
  const newMajor = prompt('전공', member.major);
  const newGeneration = Number(prompt('기수', member.generation));
  const newPart = prompt('파트', member.part);

  let result2;
  if (member.studentId !== null && member.studentId !== undefined) {
    const newStudentId = prompt('학번', member.studentId);
    result2 = await MemberAPI.updateLion(id, {
      name: newName, major: newMajor, generation: newGeneration, part: newPart, studentId: newStudentId,
    });
  } else {
    const newPosition = prompt('직책', member.position);
    result2 = await MemberAPI.updateStaff(id, {
      name: newName, major: newMajor, generation: newGeneration, part: newPart, position: newPosition,
    });
  }

  if (result2.ok) {
    showToast('멤버 정보가 수정되었습니다.');
    loadMembers(document.getElementById('part-filter').value);
  }
}

// ================== 멤버 삭제 ==================
async function deleteMember(id) {
  if (!confirm('정말 삭제하시겠습니까?')) return;
  const result = await MemberAPI.delete(id);
  if (result.ok) {
    showToast('멤버가 삭제되었습니다.');
    loadMembers(document.getElementById('part-filter').value);
    loadMemberOptions();
  }
}

// ================== 과제 등록용 멤버 셀렉트 옵션 채우기 ==================
async function loadMemberOptions() {
  const result = await MemberAPI.getAll('');
  const select = document.getElementById('assignment-member-select');
  if (!select) return;
  select.innerHTML = '';
  if (!result.ok || !Array.isArray(result.data)) return;

  result.data.forEach((member) => {
    const option = document.createElement('option');
    option.value = member.id;
    option.textContent = `${member.name} (${member.part})`;
    select.appendChild(option);
  });
}
