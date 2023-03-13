$(document).ready(function () {
  // Gerar um código de verificação aleatório de 5 dígitos
  var codigoAutenticacao = Math.floor(Math.random() * 100000).toString().substring(0, 5);

  // Recupera o valor da variável email armazenado em localStorage
  var email = localStorage.getItem('email');

  // Adiciona o código de autenticação ao corpo do e-mail e o envia para o usuário
  $.ajax({
    url: "https://api.sendgrid.com/v3/mail/send",
    type: "POST",
    headers: {
      "Authorization": "Bearer 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",
      "Content-Type": "application/json"
    },
    data: JSON.stringify({
      "personalizations": [
        {
          "to": [
            {
              "email": email
            }
          ],
          "subject": "Código de verificação - Texugo Access"
        }
      ],
      "from": {
        "email": "texugoaccess@gmail.com"
      },
      "content": [
        {
          "type": "text/plain",
          "value": "Seu código de verificação é: " + codigoAutenticacao
        }
      ]
    }),
    success: function () {
      console.log("Email enviado com sucesso!");
    },
    error: function (xhr, status, error) {
      console.error("Erro ao enviar o email: " + error);
    }
  });

  // Adiciona evento ao botão de enviar
  $('#btn-enviar').on('click', function () {
    // Seleciona todos os inputs dentro da div com a classe "codigo"
    var inputs = $('.codigo input');
    var codigo = '';

    // Itera por cada input e concatena seu valor atual à variável 'codigo'
    inputs.each(function () {
      codigo += $(this).val();
    });

    // Verifica se o código digitado pelo usuário é igual ao código de autenticação
    if (codigo === codigoAutenticacao) {
      // Realiza a chamada AJAX para alterar a variável verificado para true
      $.ajax({
        url: "http://localhost:8080/usuarios/email/" + email,
        type: "PUT",
        data: {
          "verificado": true
        },
        success: function (data) {
          window.location.href = "CadastroSucesso.html"
          console.log("Variável verificado alterada com sucesso!");
        },
        error: function (xhr, status, error) {
          console.error("Erro ao alterar a variável verificado: " + error);
        }
      });
    } else {
      console.log("Código incorreto!");
    }
  });
});
