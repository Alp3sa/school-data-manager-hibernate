/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicio;

import controlador.ControladorMenu;
/**
 *
 * @author Alfonso Pérez Santana
 */
public class inicio extends ClassLoader {
    // Iniciamos la aplicación desde la clase inicio creando un objeto menu.
    public static void main(String[] args) {     
        ControladorMenu menu = new ControladorMenu();
    }
}