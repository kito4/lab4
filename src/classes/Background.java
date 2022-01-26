package classes;

import abstractions.Location;

public class Background extends Location {
    public Background(String name) {
        super(name);
    }
    public static class Weather{
        String status;

        public Weather(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
    @Override
    public String toString() {
        return "Background{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getLocation(Location p1) {
        return p1.name;
    }
}
