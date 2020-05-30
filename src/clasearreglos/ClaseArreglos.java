/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasearreglos;
 import java.util.Scanner;
/**
 *
 * @author Alejandro
 */
public class ClaseArreglos {

   
    /**
     * @param args the command line arguments
     */
    
    Integer [] Aenteros;
    int indice=0;
    
    public static void main(String[] args) {
        
        ArreglosMulti AM=new ArreglosMulti(3,4);
        AM.menu();
        // TODO code application logic here
/*        ClaseArreglos a = new ClaseArreglos();
        
 a.inicializaarreglo(0,10);
 
 Scanner sc = new Scanner(System.in);
 
 System.out.println("Ingrese un valor para agregar al arreglo ");
 int v = sc.nextInt();
 a.agregar(v);
 System.out.println("Ingrese un valor para agregar al arreglo ");
 v = sc.nextInt();
 a.agregar(v);
 System.out.println("Ingrese la cantidad de elementos que desea ver: ");
 int cant = sc.nextInt();
 a.muestraArreglo(cant);
 System.out.println("Indice--> "+a.indice);
 
        System.out.println("Buscar elemento");
        System.out.println("ingresa el elemento a buscar");
        v = sc.nextInt();
        Integer vI=a.buscar(v);
        if(vI!=null){
            System.out.println("Elemento encontrado "+vI);
        }else{
            System.out.println("Elemento no encontrado");
        }
 
        System.out.println("Eliminar elemento");
        System.out.println("ingresa el elemento a Eliminar");
        v = sc.nextInt();
        
        if(a.Eliminar(v)){
            System.out.println("Elemento "+v+" Eliminado");
        }else{
            System.out.println("Elemento no encontrado");
        }
         System.out.println("Modificar elemento");
        System.out.println("ingresa el elemento a Modificar");
        v = sc.nextInt();
        System.out.println("ingresa el elemento Nuevo");
        int vx = sc.nextInt();
        
        if(a.modificar(v,vx)){
            System.out.println("Elemento "+v+" modificado por "+vx);
        }else{
            System.out.println("Elemento no encontrado");
        }
        a.muestraArreglo(cant);
    }
     public ClaseArreglos(){
 //int [] Aent = {2,3,45,12,10,12,11,13,45,34};
 this.Aenteros=new persona[10];
 this.Aenteros[1].setNombre("Alejandro Medina");
 */
}
     public void menu(){
         
     }

 public void inicializaarreglo(int valor,int cant){
 for(int i=0;i<cant;i++){
    Aenteros[i]=valor;
 }
 }

 public void muestraArreglo(){
 for(int i=0;i<Aenteros.length;i++){
   System.out.println("Posicion " + i + " :" + Aenteros[i]);
 }
 }
 public void muestraArreglo(int cantidad){
 
 for(int i=0; i<cantidad;i++){
 
  System.out.println("Posición " + i + " : " + Aenteros[i]);
 }
 }
 public void agregarvarios(){
     
 }
         
 public void agregar(int valor){
     if(indice<Aenteros.length){
         
        Aenteros[indice++]=valor; 
     }else{
         System.out.println("Arreglo esta lleno");
   }
 }
 
 public Integer buscar(int valor){
     for(int i=0;i<indice;i++){
         if(valor==Aenteros[i]){
             return Aenteros[i];
         }
     }
     
     return null;
     
 }
 
 public int buscarPos(int valor){
     for(int i=0;i<indice;i++){
         if(valor==Aenteros[i]){
             return i;
         }
     }
     
     return -1;
     
 }
 
 public boolean Eliminar(int valor){
     int r=buscarPos(valor);
     if(r>-1){
         Aenteros[r]=-1;
         return true;
     }else{
         return false;
     }
 }
 
 public boolean modificar(int valorB,int valorM){
     int r=buscarPos(valorB);
     if(r>-1){
         Aenteros[r]=valorM;
         return true;
     }
         return false;
     
     
 }
         
 
}
