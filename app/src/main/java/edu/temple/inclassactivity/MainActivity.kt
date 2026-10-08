package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        typedArray.recycle()

        // Attach an instance of ImageDisplayFragment using factory method
        //use add operation
        //Will likely need to edit the xml
        //val bundle = Bundle()

        //Need to have several images, so spelling out individual val fragments does not work.

        //val imageFra = ImageDisplayFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainerView, ImageDisplayFragment.newInstance(imageArray))
            .commit()


        //supportFragmentManager
        //    .beginTransaction()
            //.add(R.id.) need to create a imagefragmentcontiner, maybe in xml, and attach it?
        //Teacher said only one to two lines is needed in MainActivity.
        //Fragments depends on information being provided at start up.
        //This means android cannot create this without a specific code.


    }
}