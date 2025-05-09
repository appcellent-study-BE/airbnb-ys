package com.example.airbnb_ys.model;

import jakarta.persistence.*;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISHLIST_ID")
    private Long wishlistId;

    @ManyToOne
    @JoinColumn(name = "WISHLIST_FOLDER_ID")
    private WishlistFolder wishlistFolderId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room roomId;
}
