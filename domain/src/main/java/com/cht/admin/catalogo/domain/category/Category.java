package com.cht.admin.catalogo.domain.category;

import java.time.Instant;
import java.util.UUID;

public class Category {
   private String id;
   private String name;
   private String description;
   private boolean active;
   private Instant createdAt;
   private Instant updatedAt;
   private Instant deletedAt;

   private Category(
           String id,
           String name,
           String description,
           boolean active,
           Instant createdAt,
           Instant updatedAt,
           Instant deletedAt) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.active = active;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
      this.deletedAt = deletedAt;
   }

   public static Category newCategory(String aName, String aDescription, boolean aIsActive) {
      final var id = UUID.randomUUID().toString();
      final var now = Instant.now();
      return new Category(id,aName,aDescription,aIsActive,now,now,now);

   }

   public String getId() {
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