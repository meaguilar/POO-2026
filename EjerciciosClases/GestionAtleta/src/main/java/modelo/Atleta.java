package modelo;

public class Atleta {

    private String nombre;
    private int edad;
    private String deporte;
    private double peso;
    private double altura;
    private double horasEntrenamientodiarias;

    // Nuevo atributo
    private double imc;
    private double promHorasEntrenamiento;

    // Construct vacio
    public Atleta(){}

    // Constructor parametrizado
    public Atleta(String nombre, int edad, String deporte, double peso, double altura, double horas, double imc) {
        this.nombre = nombre;
        this.edad = edad;
        this.deporte = deporte;
        this.peso = peso;
        this.altura = altura;
        this.horasEntrenamientodiarias = horas;
        this.imc = imc;

    }

    // Metodos getter y setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDeporte() {
        return deporte;
    }
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getPromHorasEntrenamiento() {
        return promHorasEntrenamiento;
    }
    public void setPromHorasEntrenamiento(double promHorasEntrenamiento) {
        this.promHorasEntrenamiento = promHorasEntrenamiento;
    }

    public double getHorasEntrenamientodiarias() {
        return horasEntrenamientodiarias;
    }
    public void setHorasEntrenamientodiarias(double horasEntrenamientodiarias) {
        this.horasEntrenamientodiarias = horasEntrenamientodiarias;
    }
    public double getImc() {
        return imc;
    }
    public void setImc(double imc) {
        this.imc = imc;
    }

    // Metodos de lógica de negocio
    public double calcularPromedioSemanalEntrenamiento(){
        double promedio = (horasEntrenamientodiarias * 7) / 7;
        return Math.round(promedio * 100) / 100.0;
    }

    public double calcularIMC(){
        double imc = peso / (altura * altura);
        // redondear el valor
        return Math.round(imc * 100.0) / 100.0;

    }

    public void clasificarIMC(){
        if (imc < 18.5){
            System.out.println("Bajo peso");
        } else if (imc >= 18.5 && imc < 25) {
            System.out.println("Peso normal");
        } else if (imc >= 25 && imc < 30) {
            System.out.println("Sobrepeso");
        } else if (imc >= 30) {
            System.out.println("Obesidad");
        }
    }

    public void clasificarRendimiento(){
        if (promHorasEntrenamiento < 5){
            System.out.println("Poco entrenamiento");
        } else if (promHorasEntrenamiento >= 5 &&  promHorasEntrenamiento<= 9) {
            System.out.println("Nivel intermedio");
        }else if(promHorasEntrenamiento >= 10 && promHorasEntrenamiento<= 14){
            System.out.println("Buen nivel");
        } else if (promHorasEntrenamiento >= 15) {
            System.out.println("Alto rendimiento");
        }
    }

    public void mostrarAtleta(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Deporte: " + getDeporte());
        System.out.println("Peso: " + getPeso());
        System.out.println("Altura: " + getAltura());
        System.out.println("IMC: " + getImc());
        System.out.println("Horas de entrenamiento por cada dia de la semana: " + getHorasEntrenamientodiarias());
    }


}
