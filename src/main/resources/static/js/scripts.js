const API_URL = "/pacientes";

async function listar() {
    const res = await fetch(API_URL);
    const dados = await res.json();
    const body = document.getElementById("listaPacientes");
    body.innerHTML = dados.map(p => `
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nome}</td>
                    <td>${p.cpf}</td>
                    <td>${p.email}</td>
                    <td>
                        <button onclick="excluir(${p.id})" class="btn btn-danger btn-sm">Excluir</button>
                    </td>
                </tr>
            `).join('');
}

document.getElementById("formPaciente").addEventListener("submit", async (e) => {
    e.preventDefault();

    const campoErro = document.getElementById("erroCpf");
    const inputCpf = document.getElementById("cpf");
    campoErro.style.display = "none";
    inputCpf.classList.remove("is-invalid");

    const payload = {
        nome: document.getElementById("nome").value,
        cpf: document.getElementById("cpf").value,
        email: document.getElementById("email").value
    };
    const response = await fetch(API_URL, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(payload)
    });

    if (response.ok) {
        alert("Paciente cadastrado com sucesso!");
        e.target.reset();
        listar();
    } else {
        campoErro.innerText = "CPF inválido ou já cadastrado.";
        campoErro.style.display = "block";
        inputCpf.classList.add("is-invalid");
    }
});

async function excluir(id) {
    if(confirm("Deseja excluir?")) {
        await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
        listar();
    }
}

window.onload = listar;