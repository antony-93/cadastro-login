$(document).ready(function () {
    $("#number").keypress(function (event) {
        var charCode = (event.which) ? event.which : event.keyCode;
        if (charCode > 31 && (charCode < 48 || charCode > 57)) {
            return false;
        }
        var number = $(this).val();
        if (number.length === 0) {
            number = "(" + number;
            $(this).val(number);
        } else if (number.length === 3) {
            number += ") ";
            $(this).val(number);
        } else if (number.length === 11) {
            number = number.slice(0, 10) + "-" + number.slice(10);
            $(this).val(number);
        }
        if (number.length >= 15) {
            return false;
        }
        return true;
    });

    $("form").submit(function (event) {
        event.preventDefault();

        var senha = $("#password").val();
        var confirmeSenha = $("#Confirmpassword").val();

        if (senha !== confirmeSenha) {
            alert("As senhas não coincidem. Por favor, tente novamente.");
            $("#Confirmpassword").addClass("error");
        } else {
            $("#Confirmpassword").removeClass("error");
            var nome = $("#firstname").val() + " " + $("#lastname").val();
            var email = $("#email").val();
            var telefone = $("#number").val();
            var genero = $("input[name='gender']:checked").val();

            var usuario = {
                email: email,
                nome: nome,
                telefone: telefone,
                genero: genero,
                senha: senha
            };

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/usuarios",
                data: JSON.stringify(usuario),
                contentType: "application/json",
                success: function (response) {
                    alert("Usuário cadastrado com sucesso!");
                    window.location.href = "CadastroSucesso.html";
                },
                error: function (error) {
                    console.log(usuario)
                    console.log(error);
                    alert("Erro ao cadastrar usuário. Por favor, tente novamente.");
                }
            });

            // Armazena o valor da variável email em localStorage
            localStorage.setItem('email', email);

        }
    });
});

