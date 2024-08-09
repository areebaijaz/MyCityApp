package com.example.mycityapp.ui.theme

import com.example.mycityapp.Dataofcofeeshops
import com.example.mycityapp.Dataofmalls
import com.example.mycityapp.Dataofpark
import com.example.mycityapp.Datasource

import com.example.mycityapp.R

object Data {
    val data = listOf(
        Datasource(
            resnames = R.string.arbian_cheff,
            description = R.string.arbian_chef_des
        ),
        Datasource(
            resnames = R.string.eat_onn,
           description = R.string.eat_onn_des
        ),
        Datasource(
            resnames = R.string.nawab_royal,
            description = R.string.nawab_royal_des
        ),
        Datasource(
            resnames = R.string.alaska,
            description = R.string.alaska_des
        ),
        Datasource(
            resnames = R.string.royal_dera,
           description = R.string.royal_dera_des
        ),
        Datasource(
            resnames = R.string.kirana_bar,
            description = R.string.kirana_bar_des
        ),
        Datasource(
            resnames = R.string.chilli_chuttni,
            description = R.string.chilli_chuttni_des
        ),
    )
    val datapark = listOf(
        Dataofpark(
            parknames = R.string.rehmat_ullil_Alamin,
           descriptionpark = R.string.rehmat_ullil_Alamin_des1
        ),
        Dataofpark(
            parknames = R.string.Tiwana,
            descriptionpark = R.string.Tiwana_des1
        ),
        Dataofpark(
            parknames = R.string.joyland,
            descriptionpark = R.string.joyland_des1

        ),
        Dataofpark(
            parknames = R.string.jinnah,
            descriptionpark = R.string.jinnah_des1
        ),
        Dataofpark(
            parknames = R.string.old_civil_lines,
            descriptionpark = R.string.old_civil_lines_des1
        ),
        Dataofpark(
            parknames = R.string.model_mart,
            descriptionpark = R.string.model_mart_des1
        ),
    )
    val Shops = listOf(
        Dataofcofeeshops(
            shopsname = R.string.starbucks,
            descriptioncofee = R.string.starbucks_des2
        ),
        Dataofcofeeshops(
            shopsname = R.string.barista,
            descriptioncofee = R.string.barista_des2
        ),
        Dataofcofeeshops(
            shopsname = R.string.indian_cafe_house,
            descriptioncofee = R.string.indian_cafe_house_des2
        ),
        Dataofcofeeshops(
            shopsname = R.string.heebee,
            descriptioncofee = R.string.heebee_des2
        ),
        Dataofcofeeshops(
            shopsname = R.string.fat_tiger,
            descriptioncofee = R.string.fat_tiger_des2
        ),
        Dataofcofeeshops(
            shopsname = R.string.tim_hortons,
            descriptioncofee = R.string.tim_hortons_des2
        ),
    )
    val Malls = listOf(
        Dataofmalls(
            mallsname = R.string.imtiaz_mall,
            descriptionmall = R.string.imtiaz_mall_description
        ),
        Dataofmalls(
            mallsname = R.string.modern_shopping_mall,
            descriptionmall = R.string.modern_shopping_mall_description
        ),
        Dataofmalls(
            mallsname = R.string.burj_huraira,
            descriptionmall = R.string.burj_huraira_description
        ),
        Dataofmalls(
            mallsname = R.string.burj_ismail,
            descriptionmall = R.string.burj_ismail_description
        ),
        Dataofmalls(
            mallsname = R.string.chen_one_tower,
            descriptionmall = R.string.chen_one_tower_description
        ),
        Dataofmalls(
            mallsname = R.string.xin_mall,
            descriptionmall = R.string.xin_mall_description
        ),
    )
}