package twitt;

public class TwittMap {

	public static String check(String id) {
		if (id.contains("Jonas%20Sj%C3%B6stedt")) {
			id = "@jsjostedt";
			System.out.println("ID intercepted and set to @jsjostedt");
		} else if (id.contains("Stefan%20L%C3%B6fven")) {
			id = "@SwedishPM";
			System.out.println("ID intercepted and set to @SwedishPM");
		} else if (id.contains("Isabella%20L%C3%B6vin")) {
			id = "@IsabellaLovin";
			System.out.println("ID intercepted and set to @IsabellaLovin");
		} else if (id.contains("Jimmie%20%C3%85kesson")) {
			id = "@jimmieakesson";
			System.out.println("ID intercepted and set to @jimmieakesson");
		} else if (id.contains("Ebba%20Busch%20Thor")) {
			id = "@BuschEbba";
			System.out.println("ID intercepted and set to @BuschEbba");
		} else if (id.contains("Jan%20Bj%C3%B6rklund")) {
			id = "@bjorklundjan";
			System.out.println("ID intercepted and set to @bjorklundjan");
		} else if (id.contains("Anna%20Kinberg%20Batra")) {
			id = "@KinbergBatra";
			System.out.println("ID intercepted and set to @KinbergBatra");
		} else if (id.contains("Annie%20L%C3%B6%C3%B6f")) {
			id = "@annieloof";
			System.out.println("ID intercepted and set to @annieloof");
		}
		return id;
	}

}
