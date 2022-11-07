package creationalPatterns.exercise2;

import java.util.Date;

public class JobPosition {
    private final Date Published_Date;
    private String Title;
    private String Description;
    private String Location;
    private int SalaryCap;
    private boolean isRemote;

    private int YearsOfExperience;

    public static class Builder {

        //Required Parameters
        private Date Published_Date;
        private String Title;
        private boolean isRemote;

        //Optional Parameters
        private String Description = "This is where to right the description";
        private String Location = "Israel";
        private int SalaryCap = 10000;
        private int YearsOfExperience = 3;


        public Builder(Date date, String title, boolean isRemote) {
            this.Published_Date = date;
            this.Title = title;
            this.isRemote = isRemote;
        }

        public Builder description(String description) {
            this.Description = description;
            return this;
        }


        public Builder location(String location) {
            this.Location = location;
            return this;
        }

        public Builder salaryCap(int salary_cap) {
            this.SalaryCap = salary_cap;
            return this;
        }

        public Builder YearsOfExperience(int years) {
            this.YearsOfExperience = years;
            return this;
        }

        public JobPosition build() {
            return new JobPosition(this);
        }

    }

    public JobPosition(Builder builder) {
        Published_Date = builder.Published_Date;
        Title = builder.Title;
        this.isRemote = builder.isRemote;
        Description = builder.Description;
        Location = builder.Location;
        SalaryCap = builder.SalaryCap;
        YearsOfExperience = builder.YearsOfExperience;
    }
}
