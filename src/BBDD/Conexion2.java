package BBDD;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.sql.Date; // Importante importar la clase Date de java.sql
import java.util.Scanner;


public class Conexion2 {

    private Statement statement = null;
    private ResultSet resultSet = null;
    private Connection conexion = null;

    public static void main(String[] args) throws SQLException {

// Ejecutarlo
        Conexion2 miConexion2 = new Conexion2();
        try {
            Scanner sc = new Scanner(System.in);
            int valor = -1; // Inicializamos valor con un número que no sea 0 para entrar al bucle

            while (valor != 0) {
                System.out.println("\nSeleccione opción:");
                System.out.println("1 - SELECTALL");
                System.out.println("2 - SELECT");
                System.out.println("3 - INSERT");
                System.out.println("4 - UPDATE");
                System.out.println("5 - DELETE");
                System.out.println("0 - Salir");
                System.out.print("Opción:");
                valor = sc.nextInt();

                switch (valor) {
                    case 1:
                        miConexion2.SELECTALL();
                        break;
                    case 2:
                        miConexion2.SELECT();
                        break;
                    case 3:
                        miConexion2.INSERT();
                        break;
                    case 4:
                        miConexion2.UPDATE();
                        break;
                    case 5:
                        miConexion2.DELETE();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Introduce un número válido.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Conectar() throws SQLException {
        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/accesoadatos";
        String usuario = "root";
        String contrasena = "admin";

        Connection connection = DriverManager.getConnection(url, usuario, contrasena);

        // Objeto Connection para establecer la conexión
        this.conexion = DriverManager.getConnection(url, usuario, contrasena);

    }

    private void SELECTALL() throws SQLException {

        //Conectarlo a la base de datos
        Conectar();
        // Crear una declaración SQL
        statement = conexion.createStatement();

        // Consulta SQL para obtener los campos
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

    private void SELECT() throws SQLException {

        //Conectarlo a la base de datos
        Conectar();

        // Consulta SQL para obtener los campos
        String consulta = "SELECT emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no FROM Empleados WHERE emp_no = ?";

        // Crear una sentencia preparada para la consulta
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del empleado:");
        int empleadoId = sc.nextInt();

        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        preparedStatement.setInt(1, empleadoId); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet = preparedStatement.executeQuery();

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
        conexion.close();
    }

    private void INSERT() throws SQLException {
        //Conectar a la base de datos
        Conectar();

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el número de empleado (emp_no):");
        int nuevoEmpNo = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea pendiente

        System.out.println("Ingrese el apellido:");
        String nuevoApellido = sc.nextLine();

        System.out.println("Ingrese el oficio:");
        String nuevoOficio = sc.nextLine();

        System.out.println("Ingrese el número de dirección (dir):");
        int nuevaDir = sc.nextInt();
        sc.nextLine(); // Consumir la nueva línea pendiente

        System.out.println("Ingrese la fecha de alta (AAAA-MM-DD):");
        String fechaAltString = sc.nextLine();
        Date nuevaFechaAlt = Date.valueOf(fechaAltString);

        System.out.println("Ingrese el salario:");
        float nuevoSalario = sc.nextFloat();

        System.out.println("Ingrese la comisión:");
        float nuevaComision = sc.nextFloat();

        System.out.println("Ingrese el número de departamento (dept_no):");
        int nuevoDeptNo = sc.nextInt();

        // Consulta SQL para insertar un nuevo registro en la tabla Empleados
        String consulta = "INSERT INTO Empleados(emp_no, apellido, oficio, dir, fecha_alt, salario, comision, dept_no) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Crear una sentencia preparada para ejecutar la inserción
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        preparedStatement.setInt(1, nuevoEmpNo);
        preparedStatement.setString(2, nuevoApellido);
        preparedStatement.setString(3, nuevoOficio);
        preparedStatement.setInt(4, nuevaDir);
        preparedStatement.setDate(5, new java.sql.Date(nuevaFechaAlt.getTime()));
        preparedStatement.setFloat(6, nuevoSalario);
        preparedStatement.setFloat(7, nuevaComision);
        preparedStatement.setInt(8, nuevoDeptNo);

        // Ejecutar la inserción
        int filasInsertadas = preparedStatement.executeUpdate();

        if (filasInsertadas > 0) {
            System.out.println("Se ha insertado un nuevo empleado con ID " + nuevoEmpNo);
        } else {
            System.out.println("No se pudo insertar el nuevo empleado.");
        }

        preparedStatement.close();
        conexion.close();

    }

    private void UPDATE() throws SQLException {
        //Conectar a la base de datos
        Conectar();

        // Consulta SQL para actualizar un registro específico
        String consulta = "UPDATE Empleados SET salario = ? WHERE emp_no = ?";

        // Valores a actualizar
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el ID del empleado que quieras cambiar salario");
        int empleadoID = sc.nextInt(); // ID del empleado a actualizar

        System.out.println("Introduce el nuevo salario");
        float nuevoSalario = sc.nextFloat(); // Nuevo salario


        // Crear una sentencia preparada para ejecutar la actualización
        PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
        preparedStatement.setFloat(1, nuevoSalario);
        preparedStatement.setInt(2, empleadoID);

        // Ejecutar la actualización
        int filasActualizadas = preparedStatement.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Se ha actualizado el salario del empleado con ID " + empleadoID + " a " + nuevoSalario);
        } else {
            System.out.println("No se ha encontrado ningún empleado con el ID proporcionado.");
        }

        preparedStatement.close();
        conexion.close();

    }

    private void DELETE() throws SQLException {

    }

}
