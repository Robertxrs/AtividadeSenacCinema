function validarFormulario(event) {
        event.preventDefault();
        const nome = document.getElementById('nome').value.trim();
        const sobrenome = document.getElementById('sobrenome').value.trim();
        const cpf = document.getElementById('cpf').value.trim();
        const email = document.getElementById('email').value.trim();
        const cep = document.getElementById('cep').value.trim();
        const numero = document.getElementById('numero').value.trim();
        const logradouro = document.getElementById('logradouro').value.trim();
        const bairro = document.getElementById('bairro').value.trim();
        const cidade = document.getElementById('cidade').value.trim();
        const estado = document.getElementById('estado').value.trim();
        const produto = document.querySelector('input[name="produto"]:checked');

        let mensagemErro = '';
        if (!produto) {
            mensagemErro += 'Selecione um produto.\n';
        }
        if (!nome) {
            mensagemErro += 'O campo "Nome" é obrigatório.\n';
        }
        if (!sobrenome) {
            mensagemErro += 'O campo "Sobrenome" é obrigatório.\n';
        }
        if (!cpf || !validarCPF(cpf)) {
            mensagemErro += 'Informe um CPF válido no formato 000.000.000-00.\n';
        }
        if (!email || !validarEmail(email)) {
            mensagemErro += 'Informe um email válido.\n';
        }
        if (!cep || !validarCEP(cep)) {
            mensagemErro += 'Informe um CEP válido no formato 00000-000.\n';
        }
        if (!numero) {
            mensagemErro += 'O campo "Número" é obrigatório.\n';
        }
        if (!logradouro) {
            mensagemErro += 'O campo "Logradouro" é obrigatório.\n';
        }
        if (!bairro) {
            mensagemErro += 'O campo "Bairro" é obrigatório.\n';
        }
        if (!cidade) {
            mensagemErro += 'O campo "Cidade" é obrigatório.\n';
        }
        if (!estado) {
            mensagemErro += 'O campo "Estado" é obrigatório.\n';
        }
        if (mensagemErro) {
            alert(mensagemErro);
        } else {
            alert('Formulário enviado com sucesso!');
            document.querySelector('.orcamento').submit();
        }
    }
    function validarCPF(cpf) {
        const regexCPF = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
        return regexCPF.test(cpf);
    }
    function validarEmail(email) {
        const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regexEmail.test(email);
    }
    function validarCEP(cep) {
        const regexCEP = /^\d{5}-\d{3}$/;
        return regexCEP.test(cep);
    }
    document.querySelector('.orcamento').addEventListener('submit', validarFormulario);

