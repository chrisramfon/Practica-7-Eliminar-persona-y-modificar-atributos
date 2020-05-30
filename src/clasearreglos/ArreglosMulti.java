/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasearreglos;

import java.util.Scanner;

/**
 *
 * @author ali
 */
public class ArreglosMulti {

    private int c;
    int f;
    private int LimiteF;
    int LimiteC;
    persona[][] APersonas;
    Scanner leer = new Scanner(System.in);

    public ArreglosMulti(int filas, int columnas) {
        APersonas = new persona[filas][columnas];
        f = 0;
        c = 0;
        LimiteF = filas;
        LimiteC = columnas;
        inicializar();
    }

    public void menu() {
        int opc = 0;
        do {
            System.out.println("Menu Principal");
            System.out.println("1.-Agregar");
            System.out.println("2.-Mostrar");
            System.out.println("3.-MostrarTodo");
            System.out.println("4.-Buscar");
            System.out.println("5.-Buscar posicion");
            System.out.println("6.-Eliminar");
            System.out.println("7.-Modificar Campos");
            System.out.println("8.-Salir");
            opc = leer.nextInt();
            String nombre;
            switch (opc) {
                case 1:
                    persona px = new persona();
                    System.out.println("Agregar Persona-->");
                    System.out.println("Ingresa Nombre-->");
                    String nom = leer.next();
                    px.setNombre(nom);
                    System.out.println("Ingresa Edad-->");
                    int edad = leer.nextInt();
                    px.setEdad(edad);
                    Agregar(px);
                    break;
                case 2:
                    this.Mostrar();
                    break;
                case 3:
                    this.MostrarTodo();
                    break;
                case 4:
                    System.out.println("Buscar Persona");
                    System.out.println("Escribe el nombre de la persona");
                    nombre = leer.next();
                    persona p = this.Buscar(nombre);
                    if (p != null) {
                        System.out.println("Persona Encontrada");
                        p.mostrar();
                    } else {
                        System.out.println("persona no encontrada");
                    }

                    ;
                    break;
                case 5:
                    String nombre1;
                    System.out.println("Buscar Persona");
                    System.out.println("Escribe el nombre de la persona");
                    nombre = leer.next();
                    cordenadas cor = this.BuscarPos(nombre);
                    if (cor != null) {
                        System.out.println("Persona Encontrada en las coordenadas ->");
                        System.out.println(" fila --> " + cor.fila + "columna --> " + cor.columna);
                        APersonas[cor.fila][cor.columna].mostrar();

                        //p.mostrar();
                    } else {
                        System.out.println("persona no encontrada");
                    }

                    ;
                    break;
                case 6:
                    int eopc;
                    System.out.println("Ingresa el nombre de la persona a eliminar\n.\n.\n.\n.");
                    String mon = leer.next();
                    do {
                        System.out.println("¿Quieres eliminar a la persona?\n.\n.\n.\n.\n1. Si\n2. No");
                        eopc = leer.nextInt();
                        switch (eopc) {
                            case 1:
                                boolean resu = Eliminar(mon);
                                if (resu == false) {
                                    System.out.println("La persona no existe");
                                } else {
                                    System.out.println("Persona eliminada");
                                }
                                eopc=2;
                                break;

                            case 2:
                                System.out.println("Saliendo de eliminar persona");
                                break;
                            default:
                                System.out.println("Elige una opción valida");
                                break;
                        }
                    } while (eopc != 2);

                    break;
                case 7:
                    System.out.println("Ingresa el nombre de la persona a modificar");
                    String g = leer.next();
                    boolean res = this.ModificarCampos(g);
                   if(res != false){
                       System.out.println("Dato modificado con éxito");
                }
                default:
                    System.out.println("Elige una opcion valida");
            }
        } while (opc < 8);
    }

    public void Agregar(persona P) {
        if (f < LimiteF) {
            if (c < LimiteC) {
                this.APersonas[f][c++] = P;
            } else {

                c = 0;
                if (f < (LimiteF - 1)) {
                    this.APersonas[++f][c++] = P;
                } else {
                    System.out.println("Matriz llena");
                }
            }

        } else {
            System.out.println("Matriz llena");
        }

    }

    public void MostrarTodo() {
        for (int y = 0; y < LimiteF; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null) {
                    System.out.println("posicion Fila " + y + " col " + x + ":" + APersonas[y][x].getNombre());
                }
            }
        }
    }

    public void Mostrar() {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null) {
                    if (APersonas[y][x].getNombre() != null) {
                        System.out.println("posicion Fila " + y + " col " + x + ":" + APersonas[y][x].getNombre());
                    }
                }
            }
        }
    }

    public persona Buscar(String nom) {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null && APersonas[y][x].getNombre() != null) {
                    if (APersonas[y][x].getNombre().equals(nom)) {
                        //System.out.println("posicion Fila "+y+" col "+x+":"+APersonas[y][x].getNombre());
                        return APersonas[y][x];
                    }
                }

            }
        }

        return null;
    }

    public cordenadas BuscarPos(String nom) {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null && APersonas[y][x].getNombre() != null) {
                    if (APersonas[y][x].getNombre().equals(nom)) {
                        //System.out.println("posicion Fila "+y+" col "+x+":"+APersonas[y][x].getNombre());

                        return new cordenadas(x, y);
                    }
                }

            }
        }

        return null;
    }

    public boolean ModificarCampos(String nombre) {
        if (BuscarPos(nombre) != null) {
            cordenadas search = BuscarPos(nombre);
            int fil = search.getFila();
            int col = search.getColumna();
            persona e = APersonas[fil][col];
        int mopc;
        do{
        System.out.println("¿Qué quieres modificar?\n.\n.\n.\n1. Nombre\n2. Apellido\n3. Edad\n4. Confirmar cambios");
        mopc = leer.nextInt();
        switch(mopc){
            case 1:
                
                System.out.println("Escribe el nuevo nombre");
               String nuev = leer.next();
                e.setNombre(nuev);
               
                break;
                 case 2:
                     System.out.println("Escribe el nuevo Apellido");
               String nuevo = leer.next();
                e.setApellido(nuevo);
                break;
                 case 3:
                     System.out.println("Escribe la nueva edad");
               int nuevoo = leer.nextInt();
               e.setEdad(nuevoo);
                break;
                 case 4:
                     System.out.println("Saliendo");
                break;
                 default:
                     System.out.println("La opcion no existe");
                break;
        }
        
        }while(mopc != 4);
        return true;
         }
return false;
    }

    public boolean Modificar(String nombre) {
        cordenadas cord = this.BuscarPos(nombre);
        if (cord != null) {
            persona p = APersonas[cord.fila][cord.columna];
            p.mostrar();

            System.out.println("Ingresa el nuevo nombre (" + p.getNombre() + ")");
            String nom = leer.next();
            // APersonas[cord.fila][cord.columna].setNombre(nom);
            p.setNombre(nom);
            System.out.println("Ingresa el nuevo Apellido (" + p.getApellido() + ")");
            String ap = leer.next();
            // APersonas[cord.fila][cord.columna].setApellido(ap);
            p.setApellido(ap);
            System.out.println("Ingresa el nuevo Edad (" + p.getEdad() + ")");
            int edad = leer.nextInt();
            //APersonas[cord.fila][cord.columna].setEdad(edad);
            p.setEdad(edad);

            return true;

        } else {
            System.out.println("Persona no Encontrada");
            return false;
        }
    }

    public boolean Eliminar(String nombre) {
        //buscar por posicion
        //si lo encuentra mostrar informacion y preguntar si desea eliminar a la persona
        //si si deseas eliminarla entonces asigno una persona vacia y sino regreso false
        //si no lo encuentra regresar false

        if (BuscarPos(nombre) != null) {
            cordenadas search = BuscarPos(nombre);
            int fil = search.getFila();
            int col = search.getColumna();
            persona e = APersonas[fil][col];
            e.setEdad(0);
            e.setNombre(null);
            e.setCod(-1);
            e.setApellido("");
            return true;
        }
        return false;
    }

    public persona BuscarCodigo(int cod) {
        for (int y = 0; y <= f; y++) {
            for (int x = 0; x < LimiteC; x++) {
                if (APersonas[y][x] != null && APersonas[y][x].getNombre() != null) {
                    if (APersonas[y][x].getCod() == cod) {
                        //System.out.println("posicion Fila "+y+" col "+x+":"+APersonas[y][x].getNombre());
                        return APersonas[y][x];
                    }
                }

            }
        }

        return null;
    }

    public void inicializar() {
        for (int y = 0; y < LimiteF; y++) {
            for (int x = 0; x < LimiteC; x++) {

                APersonas[y][x] = new persona();

            }
        }
    }
}

class cordenadas {

    public int fila;
    public int columna;

    public cordenadas(int x, int y) {
        fila = y;
        columna = x;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
