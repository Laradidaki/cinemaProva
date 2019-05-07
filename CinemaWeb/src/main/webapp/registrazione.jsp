<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Akronim|Sofia|Stylish" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Registrazione</title>
<jsp:include page="frammenti/html/navbar.html"></jsp:include>
<jsp:include page="frammenti/html/bootstrap.html"></jsp:include>
<Style type="text/css">
h1{
margin-top:30px;
margin-left:530px;
font-size:45px;}
body {
  background-image: url("immagini/inception.jpg");
   background-repeat: no-repeat;
   background-size: cover;
    background-attachment: fixed;
}
label{
color:white;
}
</Style>
</head>
<body>
<h1>Registrazione</h1>
<form class="needs-validation" action="<%= request.getContextPath()+"/registrazione" %>" method="post">
  <div class="form-row" style="margin-left:400px ;margin-top:70px;">
    <div class="col-md-3 mb-3" >
      <label for="validationCustomName">Nome</label>
      <input type="text" class="form-control" name="nome" value=" " id="validationCustomName" placeholder="Inserisci il tuo nome" required>
      <div class="valid-feedback">
        Dati inseriti corretti
      </div>
    </div>
    <div class="col-md-3 mb-3" style="margin-left:80px;">
      <label for="validationCustomSurname">Cognome</label>
      <input type="text" class="form-control" name="cognome" value=" " id="validationCustomSurname" placeholder="Inserisci il tuo cognome" required>
      <div class="valid-feedback">
        Dati inseriti corretti
      </div>
    </div>
  </div>
  <div class="form-row" style="margin-left:400px;">
    <div class="col-md-3 mb-3" >
      <label for="validationCustomUsername">Username</label>
      <input type="text" class="form-control"  name="username" value=" " id="validationCustomUsername" placeholder="Inserisci uno username" required>
      <div class="valid-feedback">
         Scegli uno username.
      </div>
    </div>
    <div class="col-md-3 mb-3" style="margin-left:80px;margin-right:30px;">
      <label for="validationCustomPassword">Password</label>
      <input type="text" class="form-control"  name="password" value=" " id="validationCustomPassword" placeholder="Inserisci una password" required>
      <div class="invalid-feedback">
        Inserisci una password valida.
      </div>
    </div>
  </div>
  <div class="form-group" style="margin-left:560px;margin-right:0px;">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
      <label class="form-check-label" for="invalidCheck">
        Accetto i termini e le condizioni.
      </label>
      <div class="invalid-feedback" style="margin-left:400px;margin-right:30px;">
        Devi accettare le condizioni prima di confermare la registrazione.
      </div>
    </div>
  </div>
  <button class="btn btn-primary" type="submit" value="registrati" style="margin-left:635px;margin-top:30px;">Conferma</button>
</form>

<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>


	<jsp:include page="frammenti/html/script.html"></jsp:include>

</body>
</html>