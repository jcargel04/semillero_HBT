import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'mostrar-texto',
    templateUrl: './mostrar-texto-component.html'
})

export class MostrarMensaje implements OnInit{

 /**
 * Creamos las variables con que vamos a almacenar la información a mostrar.
 */
    public nombre: string;
    public ciudad: string;
    public mensaje: string;

    constructor(){
        /**
        * Mostramos un mensaje de control por consola.
        */
        console.log("Componente de mensaje Creado!, desplegándose en pantalla principal");
    }

    ngOnInit() : void {
        /**
        * Asignamos los valores a las variables a mostrar.
        */
        this.nombre = "Juan Carlos Argel";
        this.ciudad = "Montería";
        this.mensaje = this.nombre + " - " + this.ciudad;

    }
 
}
    