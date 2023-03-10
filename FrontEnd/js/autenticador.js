$(document).ready(function () {
  // Adiciona evento input aos campos de entrada
  $('.codigo input').on('input', function (e) {
    // Remove todos os caracteres que não são números
    $(this).val($(this).val().replace(/[^\d]/, ''));

    // Move o foco para o próximo campo de entrada quando um único caractere é digitado
    if ($(this).val().length == 1) {
      $(this).next().focus();
    }
  });

  // Adiciona evento keydown para detectar a tecla "backspace"
  $('.codigo input').on('keydown', function (e) {
    if (e.keyCode == 8 && $(this).val().length == 0) {
      $(this).prev().focus();
    }
  });

  // Gerar um código de verificação aleatório de 5 dígitos
  var codigo = Math.floor(Math.random() * 100000).toString().substring(0, 5);

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
              "email": "destinatario@exemplo.com"
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
          "value": "Seu código de verificação é: " + codigo
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

});

