import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Match {

    public static void main(String[] args){
        Student[] arr = new Student[100];

        System.out.println("Name the file you want to insert");
        Scanner kybd = new Scanner(System.in);
        String filename = kybd.next();

        try{
            Scanner fileInput = new Scanner(new FileReader(filename));
            int i = 0;

            while(fileInput.hasNextLine()){

                Scanner line = new Scanner(fileInput.nextLine());
                line.useDelimiter("[\t\r]");
                String name = line.next();
                String sex = line.next();
                String date = line.next();

                Scanner birthDateReader = new Scanner(date);
                birthDateReader.useDelimiter("-");
                int month = birthDateReader.nextInt();
                int day = birthDateReader.nextInt();
                int year = birthDateReader.nextInt();

                int quietTime = line.nextInt();
                int music = line.nextInt();
                int reading = line.nextInt();
                int chatting = line.nextInt();

                Date birthDay = new Date(year, month, day);
                Preference pref = new Preference(quietTime, music, reading, chatting);

                Student studentAdd = new Student(name, sex.charAt(0), birthDay, pref);
                arr[i++] = studentAdd;
            }

            int max = i;
            for(i = 0; i < max; i++){
                if(!arr[i].getMatched()) {
                    int bestScore = 0;
                    int bestMatch = 0;
                    for (int j = i + 1; j < max; j++) {
                        if (!arr[j].getMatched()) {
                            int currentScore = arr[i].compare(arr[j]);
                            if (currentScore > bestScore) {
                                bestScore = currentScore;
                                bestMatch = j;
                            }
                        }

                    }
                    if (bestScore != 0) {

                        arr[i].setMatched(true);
                        arr[bestMatch].setMatched(true);
                        System.out.println(arr[i].getName() + " matches  with " + arr[bestMatch].getName() + " with the score "+ bestScore);

                    } else{
                        if(!arr[i].getMatched()){
                            System.out.println(arr[i].getName() + " has no matches.");
                        }
                    }
                }

            }
                kybd.close();

            } catch(NoSuchElementException e){
                System.out.println(e);
        } catch(FileNotFoundException e){
                System.out.println(e);
        }

    }
}
