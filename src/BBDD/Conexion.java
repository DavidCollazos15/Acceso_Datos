package BBDD;

import java.sql.*;
import java.sql.Date; // Importante importar la clase Date de java.sql


public class Conexion {

    private Statement statement = null;
    private ResultSet resultSet = null;
    private Connection conexion = null;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Ejecutarlo
        Conexion miConexion = new Conexion();
        try {
            miConexion.Ej1();
            miConexion.Ej2();
        }catch (SQLException e){
            e.printStackTrace();
        }

        Class.forName("nombre_del_controlador_JDBC");


    }

    public void Conectar() throws SQLException {
        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/accesoadatos";
        String usuario = "root";
        String contrasena = "admin";

        Connection connection = DriverManager.getConnection(url, usuario, contrasena);


        Statement statement = connection.createStatement();


        // Objeto Connection para establecer la conexión
        this.conexion = DriverManager.getConnection(url, usuario, contrasena);

    }

    public void Ej1() throws SQLException {

        System.out.println("Ejercicio 1:\n");

        //Conectarlo a la base de datos
        Conectar();
        // Crear una declaración SQL
        statement = conexion.createStatement();

        // Consulta SQL para obtener los campos emp_no, oficio y dept_no
        String consulta = "SELECT emp_no, oficio, dept_no FROM Empleados";

        // Ejecutar la consulta
        resultSet = statement.executeQuery(consulta);

        // Iterar sobre los resultados y mostrar los datos
        while (resultSet.next()) {
            int emp_no = resultSet.getInt("emp_no");
            String oficio = resultSet.getString("oficio");
            int dept_no = resultSet.getInt("dept_no");

            System.out.println("Emp_No: " + emp_no + ", Oficio: " + oficio + ", Dept_No: " + dept_no);
        }
        resultSet.close();
        statement.close();
        conexion.close();
    }

    public void Ej2() throws SQLException {

        System.out.println("\nEjercicio 2:\n");

        //Conectarlo a la base de datos
        Conectar();
        // Crear una declaración SQL
        statement = conexion.createStatement();

        // Consulta SQL para obtener los campos emp_no, oficio, dept_no y dnombre
        String consulta = "SELECT e.emp_no, e.oficio, e.dept_no, d.dnombre " +
                "FROM Empleados e " +
                "JOIN Departamentos d ON e.dept_no = d.dept_no";

        // Ejecutar la consulta
        resultSet = statement.executeQuery(consulta);

        // Iterar sobre los resultados y mostrar los datos
        while (resultSet.next()) {
            int emp_no = resultSet.getInt("emp_no");
            String oficio = resultSet.getString("oficio");
            int dept_no = resultSet.getInt("dept_no");
            String dnombre = resultSet.getString("dnombre");

            System.out.println("Emp_No: " + emp_no + ", Oficio: " + oficio + ", Dept_No: " + dept_no + ", Dnombre: " + dnombre);
        }
        resultSet.close();
        statement.close();
        conexion.close();
    }

    public void SELECT() throws SQLException {

        //Conectarlo a la base de datos
        Conectar();
        // Crear una declaración SQL
        statement = conexion.createStatement();

        // Consulta SQL para obtener los campos emp_no, oficio, dept_no y dnombre
        String consulta = "SELECT emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no FROM Empleados";

        // Ejecutar la consulta
        resultSet = statement.executeQuery(consulta);

        // Iterar sobre los resultados y mostrar los datos
        while (resultSet.next()) {
            int emp_no = resultSet.getInt("emp_no");
            String apellido = resultSet.getString("apellido");
            String oficio = resultSet.getString("oficio");
            int dir = resultSet.getInt("dir");
            Date fecha_alt = resultSet.getDate("fecha_alt");
            float salario = resultSet.getFloat("salario");
            float comision = resultSet.getFloat("comision");
            int dept_no = resultSet.getInt("dept_no");

            System.out.println("Emp_No: " + emp_no +
                    ", Apellido: " + apellido +
                    ", Oficio: " + oficio +
                    ", Dir: " + dir +
                    ", Fecha_alt: " + fecha_alt +
                    ", Salario: " + salario +
                    ", Comision: " + comision +
                    ", Dept_No: " + dept_no);
        }

        resultSet.close();
        statement.close();
        conexion.close();

    }

}