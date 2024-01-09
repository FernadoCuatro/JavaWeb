function validarForma(forma) {
    var usuario = forma.usuario;
    
    if (usuario.value == "") {
        alert("Debe proporcionar un nombre de usuario");
        return false;
    }
}

// alert("Hola")
