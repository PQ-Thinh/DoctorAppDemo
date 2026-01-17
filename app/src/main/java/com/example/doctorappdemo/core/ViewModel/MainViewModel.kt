package com.example.doctorappdemo.core.ViewModel

import androidx.lifecycle.ViewModel
import com.example.doctorappdemo.core.model.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {
    private val db = FirebaseDatabase.getInstance("https://doctorappdemo-d8f10-default-rtdb.asia-southeast1.firebasedatabase.app")
    private val _category = MutableStateFlow<List<CategoryModel>>(emptyList())

    val category: StateFlow<List<CategoryModel>> = _category

    private var categoryLoaded = false

    fun loadCategory(force: Boolean) {
        if (categoryLoaded && !force) {
            return
        }
        categoryLoaded=true
        val ref=db.getReference("Category")

        ref.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<CategoryModel>()
                for (child in snapshot.children) {
                    child.getValue(CategoryModel::class.java)?.let {
                        items.add(it)
                    }
                }
                _category.value = items
            }
            override fun onCancelled(error: DatabaseError) {
                categoryLoaded = false
            }

        })
    }







}