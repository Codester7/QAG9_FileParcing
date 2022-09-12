public class Danger {


    private String[] ability;
    private String harm;
    private String whoKill;
    private int mention;

    FirstInfo firstInfo;

    public String[] getAbility() {
        return ability;
    }

    public String getHarm() {
        return harm;
    }

    public String getWhoKill() {
        return whoKill;
    }

    public int getMention() {
        return mention;
    }

    public FirstInfo getFirstInfo() {
        return firstInfo;
    }

    public class FirstInfo {
        private String type;
        private String country;
        private String secondName;
        private String parent;

        public String getType() {
            return type;
        }

        public String getCountry() {
            return country;
        }

        public String getSecondName() {
            return secondName;
        }

        public String getParent() {
            return parent;
        }

    }
}
