import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Asignación de elementos
        ArrayList<String> initialList = new ArrayList<>();
        initialList.add("Hello");
        initialList.add("Hello");
        initialList.add("Bye");
        initialList.add("World");

        //Función que no permita elementos duplicados
        LinkedHashSet<String> listFilter = FilterDuplicateValue(initialList);

        //Propuesta 1
        //Conversión a arreglo de Strings
        String[] arrayFromCollection = listFilter.toArray(new String[0]);

        //Filtrado de palabras que contengan la letra "y" (si contiene "y" se elimina el registro)
        String[] arrayYFilter = FilterByYCharacter(arrayFromCollection,"y").toArray(new String[0]);

        //Filtrado de palabras que contengan la letra "y" (si contiene "y" se queda el registro)
        String[] arrayFilter = FilterByCharacter(arrayFromCollection,"y").toArray(new String[0]);

        //Reverso del arreglo de strings
        arrayYFilter = ReverseArrayString(arrayYFilter);
        arrayFilter = ReverseArrayString(arrayFilter);

        //Reverso de los strings
        String[] arrayYOrder = ReverseString(arrayYFilter);
        String[] arrayOrder= ReverseString(arrayFilter);

        System.out.println("Arreglo original");
        for(String list : initialList){
            System.out.println(list);
        }
        System.out.println("-----");
        System.out.println("Arreglo sin la letra y");
        for(String list : arrayYFilter){
            System.out.println(list);
        }
        System.out.println("-----");
        System.out.println("Arreglo con la letra y");
        for(String list : arrayFilter){
            System.out.println(list);
        }
        System.out.println("-----");
        System.out.println("Arreglo sin la letra y al revés");
        for(String list : arrayYOrder){
            System.out.println(list);
        }
        System.out.println("-----");
        System.out.println("Arreglo con la letra y al revés");
        for(String list : arrayOrder){
            System.out.println(list);
        }

    }

    public static LinkedHashSet<String> FilterDuplicateValue (ArrayList<String> initialList){
        LinkedHashSet<String> listFilter = new LinkedHashSet<>();
        listFilter.addAll(initialList);
        return listFilter;
    }
    public static ArrayList<String> FilterByYCharacter(String[] arrayFromCollection,String str){
        ArrayList<String> arrayLCharacterFilter = new ArrayList<>(Arrays.asList(arrayFromCollection));
        arrayLCharacterFilter.removeIf(item -> item.contains(str));
        return arrayLCharacterFilter;
    }
    public static ArrayList<String> FilterByCharacter(String[] arrayFromCollection,String str){
        ArrayList<String> arrayLCharacterFilter = new ArrayList<>(Arrays.asList(arrayFromCollection));
        arrayLCharacterFilter.removeIf(item -> !item.contains(str));
        return arrayLCharacterFilter;
    }
    public static String[] ReverseArrayString(String[] arrayFromCollection){
        Collections.reverse(Arrays.asList(arrayFromCollection));
        return arrayFromCollection;
    }
    public static String[] ReverseString(String[] stringFromCollection){
        String[] stringCollection = new String[stringFromCollection.length];
        int i=0;
        for(String item : stringFromCollection){
            stringCollection[i] = new StringBuilder(item).reverse().toString();
            i++;
        }
        return stringCollection;
    }
}