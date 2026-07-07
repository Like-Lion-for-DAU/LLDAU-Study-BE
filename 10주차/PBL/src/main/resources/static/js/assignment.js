// ================== Assignment API ==================
const AssignmentAPI = {
  create: (memberId, data) => httpFetch('POST', `/members/${memberId}/assignments`, data),
  getAll: () => httpFetch('GET', '/assignments'),
  getByMember: (memberId) => httpFetch('GET', `/members/${memberId}/assignments`),
  getById: (id) => httpFetch('GET', `/assignments/${id}`),
  search: (keyword) => httpFetch('GET', `/assignments/search?keyword=${encodeURIComponent(keyword)}`),
  update: (id, data) => httpFetch('PUT', `/assignments/${id}`, data),
  delete: (id) => httpFetch('DELETE', `/assignments/${id}`),
};

// ================== 과제 등록 ==================
document.getElementById('assignment-form').addEventListener('submit', async (e) => {
  e.preventDefault();

  const memberId = document.getElementById('assignment-member-select').value;
  const title = document.getElementById('assignment-title').value;
  const description = document.getElementById('assignment-description').value;

  const result = await AssignmentAPI.create(memberId, { title, description });
  if (result.ok) {
    showToast('과제가 등록되었습니다.');
    document.getElementById('assignment-form').reset();
  }
});

// ================== 전체 과제 조회 ==================
function renderAssignments(tableId, assignments, withActions) {
  const tbody = document.querySelector(`#${tableId} tbody`);
  tbody.innerHTML = '';
  assignments.forEach((assignment) => {
    const tr = document.createElement('tr');
    tr.innerHTML = `
      <td>${assignment.id}</td>
      <td>${assignment.title}</td>
      <td>${assignment.description}</td>
      <td>${assignment.memberName}</td>
      ${withActions ? `<td>
        <button class="action-btn delete" onclick="quickDelete(${assignment.id})">삭제</button>
      </td>` : ''}
    `;
    tbody.appendChild(tr);
  });
}

document.getElementById('load-all-assignments').addEventListener('click', async () => {
  const result = await AssignmentAPI.getAll();
  if (result.ok) renderAssignments('assignment-table', result.data, true);
});

// ================== 과제 제목 검색 ==================
document.getElementById('search-btn').addEventListener('click', async () => {
  const keyword = document.getElementById('search-keyword').value;
  const result = await AssignmentAPI.search(keyword);
  if (result.ok) renderAssignments('search-table', result.data, false);
});

// ================== 과제 수정 ==================
document.getElementById('update-btn').addEventListener('click', async () => {
  const id = document.getElementById('update-id').value;
  const title = document.getElementById('update-title').value;
  const description = document.getElementById('update-description').value;

  if (!title && !description) {
    // 값이 비어있으면 조회만 수행하여 기존 값을 불러온다
    const result = await AssignmentAPI.getById(id);
    if (result.ok) {
      document.getElementById('update-title').value = result.data.title;
      document.getElementById('update-description').value = result.data.description;
    }
    return;
  }

  const result = await AssignmentAPI.update(id, { title, description });
  if (result.ok) {
    showToast('과제가 수정되었습니다.');
  }
});

// ================== 과제 삭제 ==================
document.getElementById('delete-btn').addEventListener('click', async () => {
  const id = document.getElementById('delete-id').value;
  if (!confirm('정말 삭제하시겠습니까?')) return;
  const result = await AssignmentAPI.delete(id);
  if (result.ok) {
    showToast('과제가 삭제되었습니다.');
  }
});

async function quickDelete(id) {
  if (!confirm('정말 삭제하시겠습니까?')) return;
  const result = await AssignmentAPI.delete(id);
  if (result.ok) {
    showToast('과제가 삭제되었습니다.');
    document.getElementById('load-all-assignments').click();
  }
}
