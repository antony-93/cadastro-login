$(document).ready(function() {
    // Adiciona evento input aos campos de entrada
    $('.codigo input').on('input', function(e) {
      // Remove todos os caracteres que não são números
      $(this).val($(this).val().replace(/[^\d]/,''));
  
      // Move o foco para o próximo campo de entrada quando um único caractere é digitado
      if ($(this).val().length == 1) {
        $(this).next().focus();
      }
    });
  
    // Adiciona evento keydown para detectar a tecla "backspace"
    $('.codigo input').on('keydown', function(e) {
      if (e.keyCode == 8 && $(this).val().length == 0) {
        $(this).prev().focus();
      }
    });
  });
  
