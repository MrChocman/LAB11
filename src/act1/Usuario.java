package act1;
class Usuario implements Observer {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Hola " + this.nombre + ", obtuviste una notificación: " + mensaje);
    }
}