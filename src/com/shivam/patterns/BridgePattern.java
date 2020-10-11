package com.shivam.patterns;

/*
 * Bridge Pattern
 * 
 * Bridge pattern intent is to decouple an abstraction from its implementation so that the two can vary independently.
 * 
 * 									Platform Independent -------------------- Platform Dependent
 * Concrete[FullView, ThumbnailView] -- Interface[View] ========BRIDGE======= Interface[Resource] -- Concrete[MusicView, MovieView, BookView]
 * 										Resource resource ------------------>
 * 
 * The resource member in View acts as a bridge between View and Resource.
 * 
 * Here any type of view is compatible with any type of resource so if we don't use 
 * bridge pattern, then we might have a cartesian product of all classes with each other. Eg - MusicFullView, MusicThumbnailView,
 * MovieFullView, MovieThumbnailView and so on...leading to class explosion in case we add more resources and views.
 * 
 * To avoid this we use a 'resource' member in view which dynamically links to a resource type so we don't need to create separate classes.
 * 
 */
public class BridgePattern {

	public static void main(String[] args) {
		
		Resource music = new MusicResource();
		Resource book = new BookResource();
		
		View fullMusic = new FullView(music);
		View movieTrailer = new ThumbnailView(new MovieResource());
		fullMusic.displayView();
		movieTrailer.displayView();
		
	}

}


interface View {
	String displayView();
}

interface Resource {
	String getPartialData();
	String getCompleteData();
}

class ThumbnailView implements View {

	Resource resource;
	
	public ThumbnailView(Resource res) {
		resource = res;
	}
	
	@Override
	public String displayView() {
		System.out.println("Showing Thumbnail view of Resource -> "+resource.getPartialData());
		return "Showing short thumbnail";
	}
	
}

class FullView implements View {

	//In full view we could invoke extra methods on resource which might not be required in Thumbnail view
	Resource resource;
	
	public FullView(Resource res) {
		resource = res;
	}
	
	@Override
	public String displayView() {
		System.out.println("Showing FullView view of Resource -> "+resource.getCompleteData());
		return "Showing FullView";
	}
	
}

class MusicResource implements Resource {
	// Music music; // Music could be an actual object, and MusicResource acts as a adapter for it
	@Override
	public String getPartialData() {
		return "Playing 5 seconds of music"; //We could invoke actual methods on music here, acting as an adapter
	}
	
	@Override
	public String getCompleteData() {
		return "Playing full song ........."; //We could invoke actual methods on music here, acting as an adapter
	}
	
}

class MovieResource implements Resource {
	@Override
	public String getPartialData() {
		return "Streaming the movie trailer"; 
	}
	
	@Override
	public String getCompleteData() {
		return "Streaming full movie on the device"; 
	}
	
}

class BookResource implements Resource {
	@Override
	public String getPartialData() {
		return "Showing book index only"; 
	}
	@Override
	public String getCompleteData() {
		return "Showing all chapters of the book"; 
	}
	
}