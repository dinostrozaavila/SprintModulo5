// Obtener elementos del DOM
const navbarToggler = document.querySelector('.navbar-toggler');
const navbarCollapse = document.querySelector('.navbar-collapse');

// Agregar evento de clic al botón de menú
navbarToggler.addEventListener('click', function() {
	// Alternar la clase 'show' en el menú desplegable
	navbarCollapse.classList.toggle('show');
});

// Función para mostrar u ocultar los contenidos del navbar
function toggleNavbar() {
	var navbarMenu = document.getElementById("navbarMenu");
	navbarMenu.classList.toggle("show");
}


  








