package com.cht.admin.catalogo.domain.category;

import com.cht.admin.catalogo.domain.AggregateRoot;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {
   private String name;
   private String description;
   private boolean active;
   private Instant createdAt;
   private Instant updatedAt;
   private Instant deletedAt;

   private Category(
           CategoryID id,
           String name,
           String description,
           boolean active,
           Instant createdAt,
           Instant updatedAt,
           Instant deletedAt) {
      super(id);
      this.name = name;
      this.description = description;
      this.active = active;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
      this.deletedAt = deletedAt;
   }

   public static Category newCategory(String aName, String aDescription, boolean aIsActive) {
      final var id = CategoryID.unique();
      final var now = Instant.now();
      return new Category(id,aName,aDescription,aIsActive,now,now,now);

   }

   public CategoryID getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public boolean isActive() {
      return active;
   }
}