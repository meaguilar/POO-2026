package modelo;

public abstract class Atleta implements Imprimible{

    protected String nombre;
    private int edad;
    // tipo enum
    private Deporte deporte;
    private double peso;
    private double altura;
    private double [] horasEntrenamientodiarias;

    // Nuevo atributo
    private double imc;
    private double promHorasEntrenamiento;

    // Construct vacio
    public Atleta(){
        horasEntrenamientodiarias = new double [7];
    }

    // Constructor parametrizado
    public Atleta(String nombre, int edad, Deporte deporte,
                  double peso, double altura, double [] horas,
                  double imc, double promHorasEntrenamiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.deporte = deporte;
        this.peso = peso;
        this.altura = altura;
        this.horasEntrenamientodiarias = horas;
        this.imc = imc;
        this.promHorasEntrenamiento = promHorasEntrenamiento;

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

    // Se actualizó el tipo de dato
    public Deporte getDeporte() {
        return deporte;
    }
    public void setDeporte(Deporte deporte) {
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

    // Implementación de arreglo
    public double[] getHorasEntrenamientodiarias() {
        return horasEntrenamientodiarias;
    }
    public void setHorasEntrenamientodiarias(double [] horasEntrenamientodiarias) {
        this.horasEntrenamientodiarias = horasEntrenamientodiarias;
    }

    public double getImc() {
        return imc;
    }
    public void setImc(double imc) {
        this.imc = imc;
    }
    public double getPromHorasEntrenamiento() {
        return promHorasEntrenamiento;
    }
    public void setPromHorasEntrenamiento(double promHorasEntrenamiento) {
        this.promHorasEntrenamiento = promHorasEntrenamiento;
    }

    // Metodos de lógica de negocio
    public double calcularPromedioSemanalEntrenamiento(){
        float totalHoras = 0;
        for (int i=0; i< getHorasEntrenamientodiarias().length; i++){
            totalHoras += getHorasEntrenamientodiarias()[i];
        }
        return Math.round((totalHoras / getHorasEntrenamientodiarias().length) * 100) / 100.0;
    }

    public double calcularIMC(){
        double imc = getPeso() / (getAltura()* getAltura());
        // redondear el valor
        return Math.round(imc * 100.0) / 100.0;

    }
    public void clasificarIMC(){
        if (getImc() < 18.5){
            System.out.println("Bajo peso");
        } else if (getImc() >= 18.5 && getImc() < 25) {
            System.out.println("Peso normal");
        } else if (getImc() >= 25 && getImc() < 30) {
            System.out.println("Sobrepeso");
        } else if (getImc() >= 30) {
            System.out.println("Obesidad");
        }
    }
    public void clasificarRendimiento(){
        if (getPromHorasEntrenamiento() < 5){
            System.out.println("Poco entrenamiento");
        } else if (getPromHorasEntrenamiento() >= 5 &&  getPromHorasEntrenamiento()<= 9) {
            System.out.println("Nivel intermedio");
        }else if(getPromHorasEntrenamiento() >= 10 && getPromHorasEntrenamiento()<= 14){
            System.out.println("Buen nivel");
        } else if (getPromHorasEntrenamiento() >= 15) {
            System.out.println("Alto rendimiento");
        }
    }

    @Override
    public void imprimir(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Deporte: " + getDeporte());
        System.out.println("Peso Kg: " + getPeso());
        System.out.println("Altura Mts: " + getAltura());
        System.out.println("IMC: " + getImc());
        System.out.println("Horas de entrenamiento por cada dia de la semana: ");
        for (int i=0; i< getHorasEntrenamientodiarias().length; i++){
            System.out.println("Día" + i + ": " + getHorasEntrenamientodiarias()[i] + " horas");
        }
    }

    public abstract void entrenar();

}
