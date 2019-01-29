public class Student {

    private String name;
    private char sex;
    private Date bDay;
    private Preference pref;
    private boolean matched;
    private int compatabilityScore;
    private int year, month, day;


    public Student(){
        name = "Jim";
        sex = 'M';
        matched = false;
        bDay = new Date(year, month, day);
    }
    public Student(String name, char sex, Date bDay, Preference pref){ // name and gender
        this.name = name;
        this.sex = sex;
        this.bDay = bDay;
        this.pref = pref;

    }



    public void setName(String name){
        this.name = name;
    }

    public void setSex(char sex){this.sex = sex;}

    public void setBDay(Date birthDay){this.bDay = birthDay;}

    public void setPref(Preference pref){this.pref = pref;}

    public void setMatched(boolean matched){this.matched = matched;}

    public String getName(){
        return name;
    }

    public char getSex(){return sex;}

    public Date getBDay(){return bDay;}

    public Preference getPref(){return pref;}

    public boolean getMatched(){return matched;}

    public int compare(Student st){
        if(sex != st.sex){
            return 0;
        }

        compatabilityScore = (40 - pref.compare(st.pref) ) + (60 - bDay.compare(st.bDay));

        if(compatabilityScore <= 0){
            return 0;
        }
        else if(compatabilityScore >= 100){
            return 100;
        }
        return compatabilityScore;
    }
}
