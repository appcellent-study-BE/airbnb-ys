package com.example.airbnb_ys.model;

import jakarta.persistence.*;

@Entity
public class WishlistFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISHLIST_FOLDER_ID")
    private Long wishlistFolderId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member userId;

    private String wishlistName;
}
