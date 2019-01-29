public class Date {

    private int year, month, day;

    public Date(){
        month = 1-12;
        day = 1-31;
        year = 1900-3000;
    }



    public Date(int year, int month, int day){
        if(year >=1900 && year <=2200){
            this.year = year;
        }

        if(month >= 1 && month <= 12){
            this.month = month;
        }

        if(day >= 1 && day <= 31){
            this.day = day;
        }
    }


    public int getYear(){
        return year;
    }


    public int getMonth(){
        return month;
    }


    public int dayOfYear() {
        int totalDays = 0;
        switch (month) {
            case 12:
                totalDays += 30;
            case 11:
                totalDays += 31;
            case 10:
                totalDays += 30;
            case 9:
                totalDays += 31;
            case 8:
                totalDays += 31;
            case 7:
                totalDays += 30;
            case 6:
                totalDays += 31;
            case 5:
                totalDays += 30;
            case 4:
                totalDays += 31;
            case 3:
                totalDays += 28;
            case 2:
                totalDays += 31;
        }
        totalDays += day;
        return totalDays;
    }

    public int compare(Date dt){
        int totalDifference = Math.abs((dayOfYear() + 365 * year) - (dt.dayOfYear() + 365 * dt.year));

        int numMonths = totalDifference/30;

        if(numMonths > 60){
            numMonths = 60;
        }

        return numMonths;
    }

}

