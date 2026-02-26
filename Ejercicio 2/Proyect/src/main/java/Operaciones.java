import javax.swing.JOptionPane;

public class Operaciones {
    int[] edades;

    public void crear(int N) {
        edades = new int[N];
        for (int i = 0; i < N; i++) {
            String valor = JOptionPane.showInputDialog("Edad para posicion " + i);
            if (valor != null && !valor.equals("")) {
                edades[i] = Integer.parseInt(valor);
            } else {
                JOptionPane.showMessageDialog(null, "El valor no puede ser vacio");
                i--;
            }
        }
        JOptionPane.showMessageDialog(null, "Arreglo lleno");
    }

    public void consultar() {
        if (edades == null) {
            JOptionPane.showMessageDialog(null, "Primero crea el arreglo");
            return;
        }
        for (int i = 0; i < edades.length; i++) {
        JOptionPane.showMessageDialog(null, "Posicion " + i + ": " + edades[i]);
    }
}

    public void buscarPorValor() {
        if (edades == null) { JOptionPane.showMessageDialog(null, "Primero crea el arreglo"); return; }
        String input = JOptionPane.showInputDialog("Ingresa el valor a buscar:");
        if (input == null || input.equals("")) return;
        int valor = Integer.parseInt(input);
        StringBuilder resultado = new StringBuilder("El valor " + valor + " se encontro en las posiciones:\n");
        boolean encontrado = false;
        for (int i = 0; i < edades.length; i++) {
            if (edades[i] == valor) {
                resultado.append("Posicion: ").append(i).append("\n");
                encontrado = true;
            }
        }
        if (!encontrado) resultado = new StringBuilder("El valor " + valor + " no se encontro en el arreglo");
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public void buscarPorPosicion() {
        if (edades == null) { JOptionPane.showMessageDialog(null, "Primero crea el arreglo"); return; }
        String input = JOptionPane.showInputDialog("Ingresa la posicion a consultar (0 a " + (edades.length - 1) + "):");
        if (input == null || input.equals("")) return;
        int pos = Integer.parseInt(input);
        if (pos < 0 || pos >= edades.length) {
            JOptionPane.showMessageDialog(null, "Posicion fuera de rango");
        } else {
            JOptionPane.showMessageDialog(null, "En la posicion " + pos + " esta el valor: " + edades[pos]);
        }
    }

    public void modificarPorPosicion() {
        if (edades == null) { JOptionPane.showMessageDialog(null, "Primero crea el arreglo"); return; }
        String inputPos = JOptionPane.showInputDialog("Posicion a modificar (0 a " + (edades.length - 1) + "):");
        if (inputPos == null || inputPos.equals("")) return;
        int pos = Integer.parseInt(inputPos);
        if (pos < 0 || pos >= edades.length) {
            JOptionPane.showMessageDialog(null, "Posicion fuera de rango");
            return;
        }
        String inputVal = JOptionPane.showInputDialog("Nuevo valor para la posicion " + pos + ":");
        if (inputVal == null || inputVal.equals("")) return;
        edades[pos] = Integer.parseInt(inputVal);
        JOptionPane.showMessageDialog(null, "Posicion " + pos + " modificada correctamente");
    }

    public void modificarPorValor() {
        if (edades == null) { JOptionPane.showMessageDialog(null, "Primero crea el arreglo"); return; }
        String inputBuscar = JOptionPane.showInputDialog("Valor a reemplazar:");
        if (inputBuscar == null || inputBuscar.equals("")) return;
        int valorViejo = Integer.parseInt(inputBuscar);
        String inputNuevo = JOptionPane.showInputDialog("Nuevo valor:");
        if (inputNuevo == null || inputNuevo.equals("")) return;
        int valorNuevo = Integer.parseInt(inputNuevo);
        boolean encontrado = false;
        for (int i = 0; i < edades.length; i++) {
            if (edades[i] == valorViejo) {
                edades[i] = valorNuevo;
                encontrado = true;
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Todos los " + valorViejo + " fueron reemplazados por " + valorNuevo);
        } else {
            JOptionPane.showMessageDialog(null, "El valor " + valorViejo + " no se encontro en el arreglo");
        }
    }

    public void eliminar() {
        if (edades == null) { JOptionPane.showMessageDialog(null, "Primero crea el arreglo"); return; }
        String input = JOptionPane.showInputDialog("Posicion a eliminar (0 a " + (edades.length - 1) + "):");
        if (input == null || input.equals("")) return;
        int pos = Integer.parseInt(input);
        if (pos < 0 || pos >= edades.length) {
            JOptionPane.showMessageDialog(null, "Posicion fuera de rango");
            return;
        }
        int[] nuevo = new int[edades.length - 1];
        for (int i = 0, j = 0; i < edades.length; i++) {
            if (i != pos) nuevo[j++] = edades[i];
        }
        edades = nuevo;
        JOptionPane.showMessageDialog(null, "Posicion " + pos + " eliminada. Nuevo tamaño: " + edades.length);
    }
}