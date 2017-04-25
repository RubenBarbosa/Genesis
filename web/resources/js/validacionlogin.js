function EnviarUsuario(){ 
				var usuario = $('#usuario').val(); 
				var password = $('#password').val();

// *********************** SIEMPRE IMPRIMA TODO PARA IR VIENDO QUE TIENE, QUE CAPTURO *******************************
console.log(usuario);
console.log(password);


if (usuario == "1014213654" && password == "12345") {     
	alert('Bienvenidooooooooo');

        // Algo esta fallando aqui al redireccionar, si algo mañana lo miramos!
        window.location.href = 'inicioCapitan.html';
        // "http://stackoverflow.com"

    }else if(usuario == "opeped@gmail.com" && password=="5678"){
    	alert('Bienvenido');
    	window.location.href = 'inicioCliente.html';
        // window.location.href("cliente.html");
    }else{
    	alert('Error: verifique que su correo y contraseña sea correcta');
    	
    }
}