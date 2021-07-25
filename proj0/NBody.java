public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);

        for (int i = 0; i < 2; i++) {
            if (!in.isEmpty()) {
                if (i == 1) {
                    return Double.parseDouble(in.readLine());
                } else in.readLine();//do nothing;
            }
        }
        return -1.0;
    }
    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int number = -1;
        number = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[number];
        for(int i=0;i<number;i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);

        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);


        StdDraw.enableDoubleBuffering();
        double cur =0.0;
        StdDraw.setScale(-radius, radius);

        for(;cur<=T;cur+=dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            int i=0;
            for(Planet one : planets){
                xForces[i] = one.calcNetForceExertedByX(planets);
                yForces[i] = one.calcNetForceExertedByY(planets);
                i++;
            }
            while(--i>=0){
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            /* Clears the drawing window. */
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(Planet one : planets){
                one.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
