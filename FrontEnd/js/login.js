$(document).ready(function () {
    $("#form-login").submit(function (event) {
        event.preventDefault();
        var email = $("#input-email").val();
        var senha = $("#input-senha").val();

        $.ajax({
            url: "http://localhost:8080/usuarios",
            type: "GET",
            success: function (data) {
                if (data.length > 0 && data[0].email === email && data[0].senha === senha) {
                    window.location.href = "Hub.html";
                } else {
                    alert("E-mail ou senha incorretos!");
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error(textStatus, errorThrown);
            }
        });
    });
});
