package com.simx.kittycat.data

import com.simx.kittycat.data.model.CatTypes
import com.simx.kittycat.data.model.Cats

/**
 * Created by simx on 06,September,2019
 */
object SampleData {
    private fun catPersia():List<Cats> {
        return listOf(
            Cats("Persia 01","https://cdn1-production-images-kly.akamaized.net/NSkUSXA3k2pizTOhIPNMcQaOZ1c=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2763269/original/061791700_1553755379-HL_3.jpg"),
            Cats("Persia 02","https://i1.wp.com/hargakatalog.id/wp-content/uploads/2019/01/sejarah-asal-daerah-kucing-persia.jpeg?resize=750%2C420&ssl=1"),
            Cats("Persia 03","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdr24WqvP1ui5Qm26wBtlUGnS98cpgbk3iJIrkNMOdyUgzivWC")
        )
    }
    private fun catSiam():List<Cats> {
        return listOf(
            Cats("Siam 01","https://upload.wikimedia.org/wikipedia/id/2/2d/Kucing_Siam.jpg"),
            Cats("Siam 02","https://i2.wp.com/www.kanal.web.id/wp-content/uploads/2016/01/kucing-siam.jpg?resize=600%2C400&ssl=1"),
            Cats("Siam 03","https://okdogi.com/wp-content/uploads/2019/01/siam-modern-860x1024.jpg")
        )
    }
    private fun catBirma():List<Cats> {
        return listOf(
            Cats("Birma 01","https://emancipationusa.com/wp-content/uploads/2019/01/kucing-birman-mata-biru.jpg"),
            Cats("Birma 01","https://upload.wikimedia.org/wikipedia/id/8/86/KucingBurmese.jpg"),
            Cats("Birma 01","https://i1.wp.com/kucing.info/wp-content/uploads/2019/03/Harga-Kucing-Birman.png?resize=843%2C629&ssl=1")
        )
    }

    fun sampleDataCats(): List<CatTypes>{
        return listOf(
            CatTypes("Persia","https://cdn1-production-images-kly.akamaized.net/NSkUSXA3k2pizTOhIPNMcQaOZ1c=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2763269/original/061791700_1553755379-HL_3.jpg", catPersia()),
            CatTypes("Siam","https://upload.wikimedia.org/wikipedia/id/2/2d/Kucing_Siam.jpg", catSiam()),
            CatTypes("Birma","https://emancipationusa.com/wp-content/uploads/2019/01/kucing-birman-mata-biru.jpg", catSiam())
        )
    }
}