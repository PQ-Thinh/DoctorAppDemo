package com.example.doctorappdemo.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.doctorappdemo.core.model.CategoryModel

@Composable
private fun CategoryItem(item: CategoryModel){

}
@Preview
@Composable
private fun CategoryItemPreview(){
    val item = CategoryModel(
        Id = 1,
        Name= "category 1",
        Picture = "https://picsum.photos/200/300")
    CategoryItem(item)
}