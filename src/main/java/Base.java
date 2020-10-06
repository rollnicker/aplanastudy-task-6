import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Base {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        FileRead red = new FileRead();

        String kek = red.readFile("C:\\Users\\Public\\Documents\\Текстовыйфайл.txt");

        String[] words = kek.split(" ");
        for (String word : words){
            list.add(word);
        }
        // Прочитать слова из файла.
        System.out.println("Ваш текст: " + kek);

        System.out.println();
        // Отсортировать в алфавитном порядке. Решение через метод sort
        Collections.sort(list);
        Iterator iterator = list.iterator();
        System.out.println("Ваш текст в алфавитном порядке: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+ ", ");
        }
        System.out.println();
        System.out.println();
        // Отсортировать в алфавитном порядке. Решение через SortedSet
        SortedSet sortedSet = new TreeSet(list);
        System.out.print("Ваш текст в алфавитном порядке,только уникальные слова: " + sortedSet);


        System.out.println();
        System.out.println();
        // Посчитать сколько раз каждое слово встречается в файле.       Вывести статистику на консоль
        Map<String, Integer> map = countWords(words);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println("Слово \"" +pair.getKey() + "\" повторялось: " + pair.getValue()+ " раз.");
            }

        System.out.println();
        // Найти слово с максимальным количеством повторений. Вывести на консоль это слово и сколько раз оно встречается в файле
        Integer max = Collections.max(map.values());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.print("Самое частое слово в тексте: \"" + entry.getKey() + "\". Повторялось: " + entry.getValue() + " раз.");
            }
        }
        }

    private static Map<String, Integer> countWords(String[] list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        for(String word : list){
            if(!result.containsKey(word)){
                result.put(word,0);
            }
            if(result.containsKey(word)){
                result.put(word,result.get(word) + 1);
            }
        }
        return result;
    }
}