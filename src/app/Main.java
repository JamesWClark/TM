package app;

import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import typicode.Post;


public class Main {

	public static void main(String[] args) {

		try {
			String sURL = "https://jsonplaceholder.typicode.com/posts/1";

			// https://stackoverflow.com/a/13632114/1161948
			Scanner scan = new Scanner(new URL(sURL).openStream(), "UTF-8");
			scan.useDelimiter("\\A");
			
			String json = scan.next();

			scan.close();

			Gson gson = new Gson();

			Post post = gson.fromJson(json, Post.class);

			System.out.println("Post = " + post.body);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
