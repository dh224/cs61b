public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67E-11;
    public Planet(double xP,double yP, double xV,double yV,
                  double mass,String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = mass;
        this.imgFileName = img;
    }
    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet another){
        double dx = (xxPos - another.xxPos) * (xxPos - another.xxPos);
        double dy = (yyPos - another.yyPos) * (yyPos - another.yyPos);
        return Math.sqrt(dx+dy);
    }

    public double calcForceExertedBy(Planet another){
        double r = this.calcDistance(another);
        double F = G * this.mass * another.mass / (r * r);
        return F;
    }
    public double calcForceExertedByX(Planet another){
        double dx = another.xxPos - this.xxPos;
        double Fx = this.calcForceExertedBy(another) * dx
                / this.calcDistance(another);
        return Fx;
    }
    public double calcForceExertedByY(Planet another){
        double dy = another.yyPos - this.yyPos;
        double Fy = this.calcForceExertedBy(another) * dy
                / this.calcDistance(another);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] others){
        double Fx=0;
        for(Planet one : others){
            if(this.equals(one)){
                continue;
            }else{
                Fx += calcForceExertedByX(one);
            }
        }
        return Fx;
    }
    public double calcNetForceExertedByY(Planet[] others){
        double Fy=0;
        for(Planet one : others){
            if(this.equals(one)){
                continue;
            }else{
                Fy += calcForceExertedByY(one);
            }
        }
        return Fy;
    }
    public void update(double dt,double fX,double fY){
        double aX = fX / this.mass;
        xxVel = xxVel + aX * dt;
        double aY = fY / this.mass;
        yyVel = yyVel + aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}

