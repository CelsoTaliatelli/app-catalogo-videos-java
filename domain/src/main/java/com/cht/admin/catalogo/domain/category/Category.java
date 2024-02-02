package com.cht.admin.catalogo.domain.category;

import com.cht.admin.catalogo.domain.AggregateRoot;
import com.cht.admin.catalogo.domain.validation.ValidationHandler;

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

   @Override
   public void validate(final ValidationHandler handler) {
      new CategoryValidator(this, handler).validate();
   }

   public Category activate() {
      this.deletedAt = null;
      this.active = true;
      this.updatedAt = Instant.now();
      return this;
   }

   public Category deactivate(){
      if (getDeletedAt() == null) {
         this.deletedAt = Instant.now();
      }

      this.active = false;
      this.updatedAt = Instant.now();
      return this;
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

   public Instant getDeletedAt() {
      return deletedAt;
   }

   public Instant getCreatedAt() {
      return createdAt;
   }

   public Instant getUpdatedAt() {
      return updatedAt;
   }

   public boolean isActive() {
      return active;
   }
}