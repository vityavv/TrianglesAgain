class Triangle {
	private Point v1, v2, v3;

	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		v1 = new Point(x1, y1);
		v2 = new Point(x2, y2);
		v3 = new Point(x3, y3);
	}
	public Triangle(Point a, Point b, Point c) {
		v1 = a;
		v2 = b;
		v3 = c;
	}
	public String classify() {
		double s1l = Math.round(10000 * v1.distanceTo(v2)) / 10000.0;
		double s2l = Math.round(10000 * v1.distanceTo(v3)) / 10000.0;
		double s3l = Math.round(10000 * v2.distanceTo(v3)) / 10000.0;
		if (s1l == s2l) {
			if (s3l == s1l) return "equilateral";
			return "isosceles";
		}
		if (s2l == s3l || s1l == s3l) return "isosceles";
		return "scalene";
	}
	public double getPerimeter() {
		return v1.distanceTo(v2) + v1.distanceTo(v3) + v2.distanceTo(v3);
	}
	public double getArea() {
		double S = getPerimeter() / 2.0;
		return Math.sqrt(S * (S - v1.distanceTo(v2)) * (S - v2.distanceTo(v3)) * (S - v3.distanceTo(v1)));
	}
	public String toString() {
		return "v1" + v1 + " v2" + v2 + " v3" + v3;
	}
	public void setVertex(int index, Point newP) {
		if (index == 0) v1 = newP;
		else if (index == 1) v2 = newP;
		else if (index == 2) v3 = newP;
	}
}
