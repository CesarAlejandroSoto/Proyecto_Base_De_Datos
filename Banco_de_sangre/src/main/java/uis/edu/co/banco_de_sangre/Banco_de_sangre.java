package uis.edu.co.banco_de_sangre;

import uis.edu.co.banco_de_sangre.controlador.Conexion;
import uis.edu.co.banco_de_sangre.controlador.ControladorPantallas;
import uis.edu.co.banco_de_sangre.vista.VDonante;
import uis.edu.co.banco_de_sangre.vista.VMenu;

public class Banco_de_sangre {

    public static void main(String[] args) {
    Conexion.getConect(); // Aquí se llama al método getConexion() en lugar de conectar()
        //VDonante ventanaDonante = new VDonante();
        //ventanaDonante.setVisible(true);
    ControladorPantallas.abrirpantallaMenu();
        
    }
}
