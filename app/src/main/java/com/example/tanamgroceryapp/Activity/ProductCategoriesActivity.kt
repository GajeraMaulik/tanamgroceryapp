package com.example.tanamgroceryapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tanamgroceryapp.Data.HomeCategoriesData
import com.example.tanamgroceryapp.Data.ShoppingCartData
import com.example.tanamgroceryapp.R
import com.example.tanamgroceryapp.Adapter.ProductCategoriesAdapter
import com.example.tanamgroceryapp.databinding.ActivityProductCategoriesBinding
import kotlinx.android.synthetic.main.activity_product_categories.*

class ProductCategoriesActivity() : AppCompatActivity(),ProductCategoriesAdapter.ClickListener {
    private  lateinit var rvProductCategories: RecyclerView
    private  lateinit var productCategoriesAdapter: ProductCategoriesAdapter
    val itemList: MutableList<ShoppingCartData> = ArrayList()
    private val productCategoriesList: MutableList<HomeCategoriesData> = ArrayList()
    private lateinit var binding: ActivityProductCategoriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductCategoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(pcToolbar)
        rvProductCategories =findViewById(R.id.rvProductCategories)


        pcbackBtn.setOnClickListener {
            onBackPressed()
            return@setOnClickListener
        }

        productCategoriesList.add(
            HomeCategoriesData(
                1,
                R.drawable.fruits,
                "Fruits",
                "45 Items",

                )
        )
        productCategoriesList.add(
            HomeCategoriesData(
                2,
                R.drawable.vegetables,
                "Vrgetables",
                "45 Items",

                )
        )
        productCategoriesList.add(
            HomeCategoriesData(
                3,
                R.drawable.bakery,
                "Bakery",
                "45 Items",

                )
        )
        productCategoriesList.add(
            HomeCategoriesData(
                4,
                R.drawable.dairy,
                "Dairy",
                "45 Items",

                )
        )
        productCategoriesList.add(
            HomeCategoriesData(
                5,
                R.drawable.mushroom,
                "Mushroom",
                "45 Items",

                )
        )
        productCategoriesList.add(
            HomeCategoriesData(
                6,
                R.drawable.fish,
                "Fish",
                "45 Items",

                )
        )
        productCategoriesList.add(
            HomeCategoriesData(
                7,
                R.drawable.pizzas,
                "Pizzas",
                "45 Items",


                )
        )
        productCategoriesList.add(
            HomeCategoriesData(
                8,
                R.drawable.chicken,
                "Chicken",
                "45 Items",

                )
        )

        rvProductCategories.adapter = ProductCategoriesAdapter(productCategoriesList,this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_productcategories,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.setting-> Toast.makeText(this,"Item 1 seleted", Toast.LENGTH_LONG).show()
            R.id.aboutUs-> Toast.makeText(this,"Item 2 seleted", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun clickedItem(homeCategoriesData: HomeCategoriesData) {
        Log.d("TAG","maulik" +homeCategoriesData.catName)
        when(homeCategoriesData.catName){
            "Fruits" ->
                startActivity(Intent(this, ProductsActivity::class.java))
            else ->
                Toast.makeText(this,"No Action",Toast.LENGTH_LONG).show()
        }
    }
}