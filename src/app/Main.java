package app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import typicode.Post;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println(getPost(3).body);
	}

	public static Post getPost(int index) 
			throws IOException, MalformedURLException {
		String sURL = "https://jsonplaceholder.typicode.com/posts/" + index;
		Scanner scan = new Scanner(new URL(sURL).openStream(), "UTF-8"); // https://stackoverflow.com/a/13632114/1161948
		scan.useDelimiter("\\A");
		String json = scan.next();
		scan.close();
		return new Gson().fromJson(json, Post.class);
	}
}
