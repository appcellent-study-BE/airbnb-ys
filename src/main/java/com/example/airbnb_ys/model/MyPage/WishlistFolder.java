package com.example.airbnb_ys.model.MyPage;

import com.example.airbnb_ys.model.Member;
import jakarta.persistence.*;

@Entity
public class WishlistFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISHLIST_FOLDER_ID")
    private int wishlistFolderId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member userId;

    @Column(length = 20)
    private String wishlistName;
}
