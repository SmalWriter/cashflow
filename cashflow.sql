use cashflow;


-- 用户表
CREATE TABLE Users (
    userId BIGINT IDENTITY(1,1) PRIMARY KEY,
    userName NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL UNIQUE,
    passwordHash NVARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL
);
SELECT * from Users;


-- 第三方登录表
CREATE TABLE UserOAuth (
    userOAuthId BIGINT IDENTITY(1,1) PRIMARY KEY,
    userId BIGINT NOT NULL,
    providerName NVARCHAR(255) NOT NULL,
    providerUserId NVARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 商品表
CREATE TABLE Products (
    productId BIGINT IDENTITY(1,1) PRIMARY KEY,
    productName NVARCHAR(255) NOT NULL,
    productDescription NVARCHAR(MAX),
    productPrice DECIMAL(18, 2) NOT NULL,
    stockQuantity INT NOT NULL,
    imageUrl NVARCHAR(MAX),
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL
);

-- 购物车表
CREATE TABLE Carts (
    cartId BIGINT IDENTITY(1,1) PRIMARY KEY,
    userId BIGINT NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 购物车明细表
CREATE TABLE CartItems (
    cartItemId BIGINT IDENTITY(1,1) PRIMARY KEY,
    cartId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    quantity INT NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL,
    FOREIGN KEY (cartId) REFERENCES Carts(cartId),
    FOREIGN KEY (productId) REFERENCES Products(productId)
);

-- 订单表
CREATE TABLE Orders (
    orderId BIGINT IDENTITY(1,1) PRIMARY KEY,
    userId BIGINT NOT NULL,
    totalAmount DECIMAL(18, 2) NOT NULL,
    orderStatus NVARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 订单明细表
CREATE TABLE OrderItems (
    orderItemId BIGINT IDENTITY(1,1) PRIMARY KEY,
    orderId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    purchasePrice DECIMAL(18, 2) NOT NULL,
    quantity INT NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL,
    FOREIGN KEY (orderId) REFERENCES Orders(orderId),
    FOREIGN KEY (productId) REFERENCES Products(productId)
);

-- 支付信息表
CREATE TABLE Payments (
    paymentId BIGINT IDENTITY(1,1) PRIMARY KEY,
    orderId BIGINT NOT NULL,
    paymentMethod NVARCHAR(255) NOT NULL,
    paymentStatus NVARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL,
    FOREIGN KEY (orderId) REFERENCES Orders(orderId)
);

-- 类别表
CREATE TABLE Category (
    categoryId BIGINT IDENTITY(1,1) PRIMARY KEY,
    categoryName NVARCHAR(255) NOT NULL
);

-- 商品和类别的联结表
CREATE TABLE ProductCategory (
    productId BIGINT NOT NULL,
    categoryId BIGINT NOT NULL,
    PRIMARY KEY (productId, categoryId),
    FOREIGN KEY (productId) REFERENCES Products(productId),
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId)
);

-- 地址表
CREATE TABLE Address (
    addressId BIGINT IDENTITY(1,1) PRIMARY KEY,
    userId BIGINT NOT NULL,
    fullAddress NVARCHAR(255),
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 库存表
CREATE TABLE Stock (
    stockId BIGINT IDENTITY(1,1) PRIMARY KEY,
    productId BIGINT NOT NULL,
    quantity INT NOT NULL,
    reservedQuantity INT,
    stockLocation NVARCHAR(255),
    batchNo NVARCHAR(255),
    stockStatus NVARCHAR(255),
    stockCost DECIMAL(10,2),
    stockValue DECIMAL(10,2),
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NULL,
    FOREIGN KEY (productId) REFERENCES Products(productId)
);

-- 评论表
CREATE TABLE Review (
    reviewId BIGINT IDENTITY(1,1) PRIMARY KEY,
    content NVARCHAR(MAX),
    rating INT,
    createdAt DATETIME NOT NULL,
    userId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId),
    FOREIGN KEY (productId) REFERENCES Products(productId)
);

-- 心愿单表
CREATE TABLE WishlistItem (
    wishlistItemId BIGINT IDENTITY(1,1) PRIMARY KEY,
    userId BIGINT NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 心愿单和商品的联结表
CREATE TABLE WishlistProduct (
    wishlistItemId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    PRIMARY KEY (wishlistItemId, productId),
    FOREIGN KEY (wishlistItemId) REFERENCES WishlistItem(wishlistItemId),
    FOREIGN KEY (productId) REFERENCES Products(productId)
);

-- 优惠券表
CREATE TABLE Coupon (
    couponId BIGINT IDENTITY(1,1) PRIMARY KEY,
    couponCode NVARCHAR(255) NOT NULL UNIQUE,
    discount DECIMAL(10, 2) NOT NULL,
    validFrom DATETIME NOT NULL,
    validTo DATETIME NOT NULL,
    userId BIGINT,
    used BIT DEFAULT 0,  -- 添加 used 字段，默认值为 0（表示未使用）
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 产品推荐表
CREATE TABLE ProductRecommendation (
    recommendationId BIGINT IDENTITY(1,1) PRIMARY KEY,
    productId BIGINT NOT NULL,
    recommendedProductId BIGINT NOT NULL,
    FOREIGN KEY (productId) REFERENCES Products(productId),
    FOREIGN KEY (recommendedProductId) REFERENCES Products(productId)
);

-- 促销表
CREATE TABLE Promotion (
    promotionId BIGINT IDENTITY(1,1) PRIMARY KEY,
    promotionDescription NVARCHAR(MAX) NOT NULL,
    startDate DATETIME NOT NULL,
    endDate DATETIME NOT NULL,
    discount DECIMAL(18, 2) NOT NULL,
    promotionType NVARCHAR(255) NOT NULL
);

-- 产品和促销活动的联结表
CREATE TABLE PromotionProduct (
    promotionId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    PRIMARY KEY (promotionId, productId),
    FOREIGN KEY (promotionId) REFERENCES Promotion(promotionId),
    FOREIGN KEY (productId) REFERENCES Products(productId)
);

-- 用户和促销活动的联结表
CREATE TABLE PromotionUser (
    promotionId BIGINT NOT NULL,
    userId BIGINT NOT NULL,
    PRIMARY KEY (promotionId, userId),
    FOREIGN KEY (promotionId) REFERENCES Promotion(promotionId),
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 类别和促销活动的联结表
CREATE TABLE PromotionCategory (
    promotionId BIGINT NOT NULL,
    categoryId BIGINT NOT NULL,
    PRIMARY KEY (promotionId, categoryId),
    FOREIGN KEY (promotionId) REFERENCES Promotion(promotionId),
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId)
);

-- 用户活动日志表
CREATE TABLE UserActivityLog (
    userActivityLogId BIGINT IDENTITY(1,1) PRIMARY KEY,
    userId BIGINT NOT NULL,
    activityType NVARCHAR(255) NOT NULL,
    activityDate DATETIME NOT NULL,
    logDescription NVARCHAR(MAX),
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 用户间的社交功能表
CREATE TABLE Follow (
    followId BIGINT IDENTITY(1,1) PRIMARY KEY,
    followerId BIGINT NOT NULL,
    followingId BIGINT NOT NULL,
    createdAt DATETIME NOT NULL,
    FOREIGN KEY (followerId) REFERENCES Users(userId),
    FOREIGN KEY (followingId) REFERENCES Users(userId)
);

-- SKU管理表
--SKU（庫存單位）管理是電子商務平台特別關注的一個方面，它涉及到產品的多個變體，例如大小、顏色等。
CREATE TABLE SKU (
    skuId BIGINT IDENTITY(1,1) PRIMARY KEY,
    productId BIGINT NOT NULL,
    skuCode NVARCHAR(255) NOT NULL,
    price DECIMAL(18, 2) NOT NULL,
    stockQuantity INT NOT NULL,
    attributes NVARCHAR(MAX),
    FOREIGN KEY (productId) REFERENCES Products(productId)
);