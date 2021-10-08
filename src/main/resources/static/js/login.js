$(document).ready(function() {
   // on ready
});


async function iniciarSesion() {
  let datos = {};
  datos.correo = document.getElementById('txtCorreo').value;
  datos.clave = document.getElementById('txtClave').value;

  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  if (respuesta != 'FAIL') {
    localStorage.token = respuesta;
    localStorage.email = datos.correo;
    window.location.href = 'usuarios.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }

}
